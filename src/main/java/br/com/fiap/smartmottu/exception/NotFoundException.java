package br.com.fiap.smartmottu.exception;

import java.util.function.Supplier;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }

    public static Supplier<NotFoundException> forUser(Long id) {
        return () -> new NotFoundException("Usuario não achado para id" + id);
    }


}
