package co.com.apirest.integracion;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import co.com.apirest.model.entities.Cliente;
import co.com.apirest.model.repository.IClienteRepository;
import co.com.apirest.testdatabuilder.ClienteTestDataBuilder;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestClienteRestController {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IClienteRepository clienteRepository;

	@Test
	public void getclientes() throws Exception {

		List<Cliente> clientes = Arrays.asList(new ClienteTestDataBuilder().build());

		when(clienteRepository.findAll()).thenReturn(clientes);

		this.mockMvc.perform(MockMvcRequestBuilders.get("/clientes/find").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andReturn();

	}

	@Test
	public void getclientesNotContent() throws Exception {

		List<Cliente> clientes = new ArrayList<Cliente>();

		when(clienteRepository.findAll()).thenReturn(clientes);

		this.mockMvc.perform(MockMvcRequestBuilders.get("/clientes/find").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isNoContent()).andReturn();

	}

	@Test
	public void getclienteById() throws Exception {

		Optional<Cliente> cliente = Optional.ofNullable(new ClienteTestDataBuilder().build());

		when(clienteRepository.findById(1L)).thenReturn(cliente);

		this.mockMvc.perform(MockMvcRequestBuilders.get("/clientes/find/{id}", 1L).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andReturn();

	}

	@Test
	public void getclienteByIdNotExist() throws Exception {

		when(clienteRepository.findById(1L)).thenReturn(null);

		this.mockMvc.perform(MockMvcRequestBuilders.get("/clientes/find/{id}", 17L).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isNoContent()).andReturn();

	}

}
