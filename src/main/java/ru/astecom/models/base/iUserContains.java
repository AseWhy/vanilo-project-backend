package ru.astecom.models.base;

import ru.astecom.models.User;

public interface iUserContains {
    User getUser();
    Long getUserId();

    void setUser(User user);
}
