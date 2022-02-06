package ru.astecom.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import ru.astecom.service.UserService;

import java.util.Set;

@Service
public class AuthProviderService implements AuthenticationProvider {
    @Autowired
    protected UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var username = authentication.getPrincipal().toString();
        var password = authentication.getCredentials().toString();

        var user = userService.login(username, password);

        return new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword(), Set.of());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
