package co.com.rest.ejemplo.integracion;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.com.rest.ejemplo.EjemploApplication;
import co.com.rest.ejemplo.model.entity.CuentaEntity;
import co.com.rest.ejemplo.model.repository.ICuentaRepository;
import co.com.rest.ejemplo.util.CuentaType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = EjemploApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class ClienteRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ICuentaRepository cuentaRepository;
	
	@Test
	public void listarCuentas() throws Exception {

		List<CuentaEntity> cuentas = Arrays.asList(new CuentaEntity(1234L, 1234L, CuentaType.AHORRO, 2500)); 

		when(cuentaRepository.findAll()).thenReturn(cuentas);

		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/cuentas").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andReturn();
	}
	
	
	

}
