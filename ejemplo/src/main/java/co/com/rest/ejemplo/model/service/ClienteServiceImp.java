package co.com.rest.ejemplo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.rest.ejemplo.exception.ApplicationException;
import co.com.rest.ejemplo.model.entity.ClienteEntity;
import co.com.rest.ejemplo.model.repository.IClienteRepository;

@Service
public class ClienteServiceImp implements IClienteService {

	private IClienteRepository clienteRepository;

	@Autowired
	public ClienteServiceImp(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public List<ClienteEntity> findAll() {
		return (List<ClienteEntity>) clienteRepository.findAll();
	}

	@Override
	public ClienteEntity findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<ClienteEntity> findActive() {
		throw new ApplicationException("Error quemado");
		//return clienteRepository.findActive();
	}

}
