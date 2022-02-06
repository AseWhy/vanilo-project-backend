package ru.astecom.service;

import org.intellij.lang.annotations.RegExp;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.astecom.DTO.user.UserRegistrationDTO;
import ru.astecom.exceptions.base.CustomException;
import ru.astecom.models.Cart;
import ru.astecom.models.User;
import ru.astecom.repository.UserRepository;
import ru.astecom.service.base.BaseService;

@Repository
public class UserService extends BaseService<User, Long, UserRepository> {
    @RegExp
    public final static String PHONE_PATTERN = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    @RegExp
    public final static String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

    @Autowired
    protected PasswordEncoder passwordEncoder;

    public UserService() {
        super(User.class);
    }

    @Transactional
    public User register(@NotNull UserRegistrationDTO payload) {
        var found = repository.findUserWithSameLogin(payload.getLogin());

        if(found.isPresent()) {
            throw new CustomException("You cannot create users with same logins.", HttpStatus.CONFLICT);
        }

        var user = new User();
        var cart = new Cart();

        if(payload.getLogin().matches(PHONE_PATTERN)) {
            user.setPhone(payload.getLogin());
        } else if(payload.getLogin().matches(EMAIL_PATTERN)) {
            user.setEmail(payload.getLogin());
        } else {
            throw new RuntimeException("The login must be a valid phone number or email.");
        }

        cart.setUser(user);

        user.setLogin(payload.getLogin());
        user.setPassword(passwordEncoder.encode(payload.getPassword()));
        user.setCart(cart);

        return save(payload.fill(user));
    }

    @Transactional(readOnly = true)
    public User login(String login, String password) {
        var found = repository.findUserWithSameLogin(login);

        if(found.isEmpty()) {
            throw new CustomException("The login or password not matches.", HttpStatus.UNAUTHORIZED);
        }

        var user = found.get();

        if(passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new CustomException("The login or password not matches.", HttpStatus.UNAUTHORIZED);
        }
    }

    @Transactional(readOnly = true)
    public User login(String login) {
        var found = repository.findUserWithSameLogin(login);

        if(found.isEmpty()) {
            throw new UsernameNotFoundException(login);
        }

        return found.get();
    }
}
