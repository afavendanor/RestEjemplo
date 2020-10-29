package co.com.apirest.exception;

public class ApplicationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ApplicationException(String mensaje) {
		super(mensaje);
	}
	
}