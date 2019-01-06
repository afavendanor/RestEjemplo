package co.com.rest.ejemplo.exception;

public class ApplicationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ApplicationException(String mensaje) {
		super(mensaje);
	}
	
}
