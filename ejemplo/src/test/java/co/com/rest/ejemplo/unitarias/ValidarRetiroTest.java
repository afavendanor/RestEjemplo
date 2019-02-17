package co.com.rest.ejemplo.unitarias;

import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import co.com.rest.ejemplo.domain.ValidarRetiro;

public class ValidarRetiroTest {

	private static double SALDO_MINIMO = 100;
	private static double VALOR_MAXIMO_TRANSFERENCIA = 5000;
	ValidarRetiro validarRetiroMock;
	

	@Before
	public void mocksInitialization() {
		MockitoAnnotations.initMocks(this);
		validarRetiroMock = ValidarRetiro.getInstance();
	}

	@Test
	public void validarSaldoMinimoTest() {		
		Mockito.verify(validarRetiroMock).validarMontoNegativo(Mockito.anyDouble());
	}

}
