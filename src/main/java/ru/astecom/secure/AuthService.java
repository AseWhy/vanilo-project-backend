package ru.astecom.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.astecom.service.UserService;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    protected UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new VaniloUserDetails(userService.login(username));
    }
}
