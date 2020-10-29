package co.com.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.apirest.model.entities.Cliente;
import co.com.apirest.model.services.IClienteService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/find")
	public ResponseEntity<List<Cliente>> findClientes() {
		List<Cliente> clientes = clienteService.findAll();

		if (clientes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Cliente> findClienteById(@PathVariable Long id) {

		Cliente cliente = clienteService.findById(id);

		if (cliente == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {

		Cliente clientesave = clienteService.save(cliente);

		if (clientesave == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id) {

		Cliente cliente = clienteService.findById(id);

		if (cliente == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		clienteService.delete(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
