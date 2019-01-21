package co.com.rest.ejemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.rest.ejemplo.model.entity.CuentaEntity;
import co.com.rest.ejemplo.model.service.ICuentaService;

@RestController
@RequestMapping("/api")
public class CuentaRestController {
	
private ICuentaService CuentaService;
	
	@Autowired
	public CuentaRestController(ICuentaService CuentaService) {
		this.CuentaService = CuentaService;
	}

	@GetMapping("/cuentas")
	public ResponseEntity<List<CuentaEntity>> listarCuentas() {
		List<CuentaEntity> cuentas = CuentaService.findAll();
		if (cuentas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cuentas, HttpStatus.OK);
	}

	@GetMapping("/Cuentas/{id}")
	public ResponseEntity<CuentaEntity> buscarCuenta(@PathVariable Long id) {
		CuentaEntity cuenta = CuentaService.findById(id);
		if (cuenta == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cuenta, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/crearCuenta")
	public ResponseEntity crearCuenta(@RequestBody CuentaEntity cuenta) {
		this.CuentaService.saveCuenta(cuenta);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/borrarCuenta/{id}")
	public ResponseEntity borrarCuenta(@PathVariable Long id) {
		this.CuentaService.deleteCuenta(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
