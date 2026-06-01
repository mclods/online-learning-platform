package com.mclods.online_learning_platform.exceptions;

public class EntityDoesNotExistException extends Exception {
    private final String message;

    public <T>EntityDoesNotExistException(Class<T> entity, Integer id) {
        message = "Trying to perform operation involving (Entity=%s, Id=%d) which does not exist.".formatted(entity.getName(), id);
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
