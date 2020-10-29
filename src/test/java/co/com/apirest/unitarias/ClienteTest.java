package co.com.apirest.unitarias;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import co.com.apirest.model.entities.Cliente;
import co.com.apirest.testdatabuilder.ClienteTestDataBuilder;

@ActiveProfiles("test")
public class ClienteTest {

	private static final String NOMBRE = "Andres Avendano";
	private static final double SALARIO = 100000;
	private static final double BONIFICACION = 0;
	private static final Date FECHA_INGRESO = new Date();
	private static final boolean ACTIVO = true;

	@Test
	public void crearClienteTest() {
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre(NOMBRE)
				.conFechaIngreso(FECHA_INGRESO).conSalario(SALARIO).conActivo(ACTIVO).conBonificacion(BONIFICACION);

		// act
		Cliente cliente = clienteTestDataBuilder.build();

		// assert
		assertEquals(NOMBRE, cliente.getNombre());
		assertEquals(SALARIO, cliente.getSalario(), 0);
		assertEquals(BONIFICACION, cliente.getBonificacion(), 0);
		assertEquals(FECHA_INGRESO, cliente.getFechaIngreso());
		assertEquals(ACTIVO, cliente.isActivo());

	}
	
	@Test
	public void crearClienteDefaultTest() {
		// arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder();

		// act
		Cliente cliente = clienteTestDataBuilder.build();

		// assert
		assertEquals(NOMBRE, cliente.getNombre());
		assertEquals(SALARIO, cliente.getSalario(), 0);
		assertEquals(BONIFICACION, cliente.getBonificacion(), 0);
		assertEquals(ACTIVO, cliente.isActivo());

	}

}
