package ru.astecom.secure;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class Helper {
    public static VaniloUserDetails getPresentInvoker() {
        return getInvoker().orElseThrow();
    }

    public static Optional<VaniloUserDetails> getInvoker() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null) {
            return Optional.of((VaniloUserDetails) authentication.getPrincipal());
        } else {
            return Optional.empty();
        }
    }
}
