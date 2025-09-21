package br.com.fiap.smartmottu.exception;

import java.util.function.Supplier;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }

    public static Supplier<NotFoundException> forUser(Long id) {
        return () -> new NotFoundException("Usuario não achado para id" + id);
    }

    public static Supplier<NotFoundException> forMoto(Long id) {
        return () -> new NotFoundException("Moto não achado para id" + id);
    }
    public static Supplier<NotFoundException> forStatusMoto(Long id) {
        return () -> new NotFoundException("StatusMoto não achado para id" + id);
    }
    public static Supplier<NotFoundException> forTipoMoto(Long id) {
        return () -> new NotFoundException("TipoMoto não achado para id" + id);
    }


}
