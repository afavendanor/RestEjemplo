package co.com.rest.ejemplo.unitarias;

import org.junit.Before;
import org.junit.Test;

import co.com.rest.ejemplo.domain.ValidarRetiro;
import co.com.rest.ejemplo.exception.ApplicationException;

public class ValidarRetiroTest {

	private static double SALDO = -1;
	private static double MONTO_MAYOR = 6000;
	private static double MONTO_NEGATIVO = -100;
	private static double VALOR_MAXIMO_TRANSFERENCIA = 5000;
	ValidarRetiro validarRetiro;
	

	@Before
	public void Initialization() {
		validarRetiro = ValidarRetiro.getInstance();
	}

	@Test
	public void validarMontoNegativoTest() {		
		ValidarRetiro.validarMontoNegativo(1200);
	}
	
	@Test(expected = ApplicationException.class)
	public void validarMontoNegativoExceptionTest() {		
		ValidarRetiro.validarMontoNegativo(SALDO);
	}
	
	@Test
	public void validarMontoTransferenciaTest() {		
		ValidarRetiro.validarMontoTransferencia(MONTO_NEGATIVO, VALOR_MAXIMO_TRANSFERENCIA);
	}
	
	@Test(expected = ApplicationException.class)
	public void validarMontoTransferenciaExceptionTest() {		
		ValidarRetiro.validarMontoTransferencia(MONTO_MAYOR, VALOR_MAXIMO_TRANSFERENCIA);
	}

	@Test
	public void validarSaldoMinimoTest() {		
		ValidarRetiro.validarSaldoMinimo(MONTO_MAYOR);
	}
	
	@Test(expected = ApplicationException.class)
	public void validarSaldoMinimoExceptionTest() {		
		ValidarRetiro.validarSaldoMinimo(MONTO_NEGATIVO);
	}
}
