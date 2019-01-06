package co.com.rest.ejemplo.model.service;

import java.util.List;

import co.com.rest.ejemplo.model.entity.ClienteEntity;

public interface IClienteService {
	
	public List<ClienteEntity> findAll();
	
	public ClienteEntity findById(Long id);
	
	public List<ClienteEntity> findActive();

}
