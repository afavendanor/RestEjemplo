package co.com.rest.ejemplo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.pmw.tinylog.Logger;
import co.com.rest.ejemplo.exception.ApplicationException;
import co.com.rest.ejemplo.util.Constantes;

public class ValidarRetiro {

	private static final String MONTO_NO_PERMITIDO = "El monto de la transacción sobrepasa el valor máximo permitido";
	private static final String MONTO_NEGATIVO = "El valor del monto de la transacción no puede ser negativo";
	private static final String SALDO_INVALIDO = "El monto retirar no es válido, el saldo final de la cuenta es inválido";

	private static ValidarRetiro validarRetiro;
	
	@Value("${valor_maximo_transferencia}")
	private static String valorMaximoTransferencia;

	private ValidarRetiro() {
	}

	public static ValidarRetiro getInstance() {
		if (validarRetiro == null) {
			validarRetiro = new ValidarRetiro();
		}
		return validarRetiro;
	}
	
	public static void validarSaldoMinimo(double saldo) {
		if(saldo < Constantes.SALDO_MINIMO) {
			Logger.debug(SALDO_INVALIDO);
			throw new ApplicationException(SALDO_INVALIDO);
		}
	}
	
	public static void validarMonto(double monto) {
		if(monto < 0) {
			Logger.debug(MONTO_NEGATIVO);
			throw new ApplicationException(MONTO_NEGATIVO);
		}
		if(monto > Double.valueOf(valorMaximoTransferencia)) {
			Logger.debug(MONTO_NO_PERMITIDO);
			throw new ApplicationException(MONTO_NO_PERMITIDO);
		}
	}
	

}
