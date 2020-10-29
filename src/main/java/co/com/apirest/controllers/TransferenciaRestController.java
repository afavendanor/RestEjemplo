package co.com.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.apirest.model.dao.Transferencia;
import co.com.apirest.model.services.ITransferenciaService;

@RestController
@RequestMapping("/transaccion")
public class TransferenciaRestController {

	private ITransferenciaService transferenciaService;

	@Autowired
	public TransferenciaRestController(ITransferenciaService transferenciaService) {
		this.transferenciaService = transferenciaService;
	}


	@PostMapping("/transferencia")
	public ResponseEntity<Transferencia> realizarTransferencia(@RequestBody Transferencia transferencia) {
		this.transferenciaService.realizarTransferencia(transferencia);
		return new ResponseEntity<>(transferencia, HttpStatus.OK);
	}

}