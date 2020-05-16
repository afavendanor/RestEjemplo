package co.com.apirest.apirest.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.apirest.apirest.model.entities.Cliente;
import co.com.apirest.apirest.model.repository.IClienteRepository;

@Service
public class ClienteServiceImp implements IClienteService{
	
	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	@Override
	public boolean isActive(Long id) {
		return clienteRepository.isActive(id);
	}

}
