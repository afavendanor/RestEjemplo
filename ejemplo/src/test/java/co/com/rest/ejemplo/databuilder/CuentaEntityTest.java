package co.com.rest.ejemplo.databuilder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.com.rest.ejemplo.model.entity.CuentaEntity;
import co.com.rest.ejemplo.util.CuentaType;

public class CuentaEntityTest {

	private static final Long ID_CLIENTE = 12345L;
	private static final Long ID_CUENTA = 54321L;
	private static double SALDO = 1000;
	private static CuentaType TIPO_CUENTA = CuentaType.AHORRO;

	@Test
	public void crearCuentaEntityTest() {

		// Arrange
		CuentaEntityTestDataBuilder cuentaEntityTestDataBuilder = new CuentaEntityTestDataBuilder()
				.conIdCuenta(ID_CUENTA).conIdCliente(ID_CLIENTE).conSaldo(SALDO).conTipoCuenta(TIPO_CUENTA);

		// Act
		CuentaEntity cuenta = cuentaEntityTestDataBuilder.build();

		// Assert
		assertEquals(ID_CLIENTE, cuenta.getIdCliente());
		assertEquals(ID_CUENTA, cuenta.getIdCuenta());
		assertEquals(SALDO, cuenta.getSaldo(), 0.00);
		assertEquals(TIPO_CUENTA, cuenta.getTipo());

	}

}
