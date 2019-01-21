package co.com.rest.ejemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.com.rest.ejemplo.model.entity.ClienteEntity;
import co.com.rest.ejemplo.model.service.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	private IClienteService clienteService;
	
	@Autowired
	public ClienteRestController(IClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteEntity>> listarClientes() {
		List<ClienteEntity> clientes = clienteService.findAll();
		if (clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<ClienteEntity> buscarCliente(@PathVariable Long id) {
		ClienteEntity cliente = clienteService.findById(id);
		if (cliente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/clientesActivos")
	public ResponseEntity<List<ClienteEntity>> buscarClienteActivos() {
		List<ClienteEntity> clientes = clienteService.findActive();
		if (clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/crearCliente")
	public ResponseEntity crearCliente(@RequestBody ClienteEntity cliente) {
		this.clienteService.saveCliente(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/borrarCliente/{id}")
	public ResponseEntity borrarCliente(@PathVariable Long id) {
		this.clienteService.deleteCliente(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
