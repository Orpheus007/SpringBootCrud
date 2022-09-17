package com.orpheus.springbootcrud.mementos;

import java.util.Optional;
import java.util.function.Function;

public class Janus<T> {
    private Optional<T> value;
    private Optional<String> error;

    private Janus(T value, String error) {
        this.value = Optional.ofNullable(value);
        this.error = Optional.ofNullable(error);
    }

    /** This is the unit method */
    public static <U> Janus<U> ok(U value) {
        return new Janus<>(value, null);
    }

    public static <U> Janus<U> error(String error) {
        return new Janus<>(null, error);
    }

    /** This is the bind method */
    public<U> Janus<U> flatMap(Function<T, Janus<U>> mapper) {

        if(this.isError()) {
            return Janus.error(this.getError());
        }

        return mapper.apply(value.get());
    }

    public boolean isError() {
        return error.isPresent();
    }

    public T getValue() {
        return value.get();
    }

    public String getError() {
        return error.get();
    }
}