package co.com.rest.ejemplo.domain;

public class ValidarRetiro {

	private static ValidarRetiro validarRetiro;

	private ValidarRetiro() {

	}

	public static ValidarRetiro getInstance() {
		if (validarRetiro == null) {
			validarRetiro = new ValidarRetiro();
		}
		return validarRetiro;
	}

}
