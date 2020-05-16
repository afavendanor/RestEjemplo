package co.com.apirest.apirest.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.apirest.apirest.model.entities.Cuenta;
import co.com.apirest.apirest.model.repository.ICuentaRepository;

@Service
public class CuentaServiceImp implements ICuentaService {

	@Autowired
	private ICuentaRepository cuentaRepository;

	@Override
	public List<Cuenta> findAll() {
		return (List<Cuenta>) cuentaRepository.findAll();
	}

	@Override
	public Cuenta findById(Long id) {
		return cuentaRepository.findById(id).orElse(null);
	}

	@Override
	public Cuenta save(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	@Override
	public void delete(Cuenta cuenta) {
		cuentaRepository.delete(cuenta);
	}

}
