package co.com.rest.ejemplo.exception;

public class ClienteNoExisteException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ClienteNoExisteException(String mensaje) {
        super(mensaje);
    }

}
