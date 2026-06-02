package com.mclods.online_learning_platform.exceptions;

public class EntityDoesNotExistException extends Exception {
    private final String message;

    public EntityDoesNotExistException(Object entity) {
        message = "Trying to perform operation involving (Entity=%s) which does not exist.".formatted(entity);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
