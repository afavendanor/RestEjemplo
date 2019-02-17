package co.com.rest.ejemplo.databuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import co.com.rest.ejemplo.model.entity.ClienteEntity;

public class ClienteEntityTest {

	private static final Long ID_CLIENTE = 12345L;
	private static final String NOMBRE_CLIENTE = "Andres Avendano";
	private static double SALARIO = 1000;
	private static double BONIFICACION = 100;

	@Test
	public void crearClienteEntityTest() {

		// Arrange
		Date fechaSolicitud = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaSolicitud);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) - 2);
		Date fechaIngreso = calendar.getTime();

		ClienteEntityTestDataBuilder clienteEntityTestDataBuilder = new ClienteEntityTestDataBuilder().conId(ID_CLIENTE)
				.conNombre(NOMBRE_CLIENTE).conSalario(SALARIO).conBonificacion(BONIFICACION)
				.conFechaIngreso(fechaIngreso).conActivo(true);
		
		//Act
		ClienteEntity cliente = clienteEntityTestDataBuilder.build();
		
		//Assert
		assertEquals(ID_CLIENTE, cliente.getId());
		assertEquals(NOMBRE_CLIENTE, cliente.getNombre());
		assertEquals(SALARIO, cliente.getSalario(), 0.00);
		assertEquals(BONIFICACION, cliente.getBonificacion(), 0.00);
		assertEquals(fechaIngreso, cliente.getFechaIngreso());
		assertTrue(cliente.activo);

	}

}
