package co.com.apirest.apirest.domain;


import org.pmw.tinylog.Logger;

import co.com.apirest.apirest.exception.ApplicationException;
import co.com.apirest.apirest.util.Constantes;


public class ValidarRetiro {

	private static final String MONTO_NO_PERMITIDO = "El monto de la transacci&oacute;n sobrepasa el valor m&aacute;ximo permitido";
	private static final String MONTO_NEGATIVO = "El valor del monto de la transacci&oacute;n no puede ser negativo";
	private static final String SALDO_INVALIDO = "El monto retirar no es v&aacute;lido, el saldo final de la cuenta es inv&aacute;lido";

	private static ValidarRetiro validarRetiro;

	private ValidarRetiro() {
	}

	public static ValidarRetiro getInstance() {
		if (validarRetiro == null) {
			validarRetiro = new ValidarRetiro();
		}
		return validarRetiro;
	}

	public static void validarSaldoMinimo(double saldo) {
		if (saldo < Constantes.SALDO_MINIMO) {
			Logger.debug(SALDO_INVALIDO);
			throw new ApplicationException(SALDO_INVALIDO);
		}
	}

	public static void validarMontoNegativo(double monto) {
		if (monto < 0) {
			Logger.debug(MONTO_NEGATIVO);
			throw new ApplicationException(MONTO_NEGATIVO);
		}
	}

	public static void validarMontoTransferencia(double monto, double valorMaximoTransferencia) {
		if (monto > valorMaximoTransferencia) {
			Logger.debug(MONTO_NO_PERMITIDO);
			throw new ApplicationException(MONTO_NO_PERMITIDO);
		}
	}

}