package ru.astecom.secure;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class Helper {
    public static VaniloUserDetails getPresentInvoker() {
        return getInvoker().orElseThrow();
    }

    public static Optional<VaniloUserDetails> getInvoker() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof VaniloUserDetails) {
            return Optional.of((VaniloUserDetails) authentication.getPrincipal());
        } else {
            return Optional.empty();
        }
    }

    public static VaniloUserDetails getInvokerNullable() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof VaniloUserDetails) {
            return (VaniloUserDetails) authentication.getPrincipal();
        } else {
            return null;
        }
    }
}
