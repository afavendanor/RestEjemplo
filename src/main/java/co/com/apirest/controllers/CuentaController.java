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

import co.com.apirest.model.entities.Cuenta;
import co.com.apirest.model.services.ICuentaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	@Autowired
	private ICuentaService cuentaService;

	@GetMapping("/find")
	public ResponseEntity<List<Cuenta>> findCuentas() {
		List<Cuenta> cuentas = cuentaService.findAll();

		if (cuentas.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(cuentas, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Cuenta> findCuentaById(@PathVariable Long id) {

		Cuenta cuenta = cuentaService.findById(id);

		if (cuenta == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(cuenta, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Cuenta> saveCuenta(@RequestBody Cuenta cuenta) {

		Cuenta cuentasave = cuentaService.save(cuenta);

		if (cuentasave == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cuenta, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Cuenta> deleteCuenta(@PathVariable Long id) {

		Cuenta cuenta = cuentaService.findById(id);

		if (cuenta == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		cuentaService.delete(cuenta);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}