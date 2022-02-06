package ru.astecom.models.base;

public interface iIdentifiable<T> {
    T getId();

    default boolean isNewEntity() {
        return getId() == null;
    }
}
