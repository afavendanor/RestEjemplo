package co.com.apirest.apirest.model.services;

import java.util.List;

import co.com.apirest.apirest.model.entities.Cuenta;

public interface ICuentaService {

	List<Cuenta> findAll();
	
	Cuenta findById(Long id);
	
	Cuenta save(Cuenta cuenta);
	
	void delete(Cuenta cuenta);
	
}
