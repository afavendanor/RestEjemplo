package co.com.apirest.model.services;

import java.util.List;

import co.com.apirest.model.entities.Cliente;

public interface IClienteService {
	
	List<Cliente> findAll();
	
	Cliente findById(Long id);
	
	Cliente save(Cliente cliente);
	
	void delete(Cliente cliente);
	
	boolean isActive(Long id);

}
