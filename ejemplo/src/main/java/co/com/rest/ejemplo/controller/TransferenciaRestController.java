package co.com.rest.ejemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.rest.ejemplo.model.dao.Transferencia;
import co.com.rest.ejemplo.model.service.ITransferenciaService;

@RestController
@RequestMapping("/api")
public class TransferenciaRestController {

	private ITransferenciaService transferenciaService;

	@Autowired
	public TransferenciaRestController(ITransferenciaService transferenciaService) {
		this.transferenciaService = transferenciaService;
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/transferencia")
	public ResponseEntity realizarTransferencia(@RequestBody Transferencia transferencia) {
		this.transferenciaService.realizarTransferencia(transferencia);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
