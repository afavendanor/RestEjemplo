package co.com.apirest.unitarias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import co.com.apirest.model.entities.Cuenta;
import co.com.apirest.testdatabuilder.CuentaTestDataBuilder;
import co.com.apirest.util.CuentaType;

@ActiveProfiles("test")
public class CuentaTest {

	private static final Long ID_CUENTA = 5812465844L;
	private static final Long ID_CLIENTE = 548512L;
	private static final CuentaType TIPO_CUENTA = CuentaType.AHORROS;
	private static final double SALDO = 25000000;

	@Test
	public void crearCuentaTest() {

		// arrange
		CuentaTestDataBuilder cuentaTestDataBuilder = new CuentaTestDataBuilder().conIdCuenta(ID_CUENTA)
				.conIdCliente(ID_CLIENTE).conCuentaType(TIPO_CUENTA).conSaldo(SALDO);

		// act
		Cuenta cuenta = cuentaTestDataBuilder.build();

		// assert
		assertEquals(ID_CUENTA, cuenta.getId_cuenta());
		assertEquals(ID_CLIENTE, cuenta.getIdCliente());
		assertEquals(TIPO_CUENTA, cuenta.getTipo());
		assertEquals(SALDO, cuenta.getSaldo(), 0);

	}

	@Test
	public void crearCuentaDefaultTest() {

		// arrange
		CuentaTestDataBuilder cuentaTestDataBuilder = new CuentaTestDataBuilder();

		// act
		Cuenta cuenta = cuentaTestDataBuilder.build();

		// assert
		assertEquals(ID_CUENTA, cuenta.getId_cuenta());
		assertEquals(ID_CLIENTE, cuenta.getIdCliente());
		assertEquals(TIPO_CUENTA, cuenta.getTipo());
		assertEquals(SALDO, cuenta.getSaldo(), 0);

	}

}
