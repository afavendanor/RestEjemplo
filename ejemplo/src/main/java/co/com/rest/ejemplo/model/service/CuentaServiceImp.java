package co.com.rest.ejemplo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.rest.ejemplo.exception.ClienteNoExisteException;
import co.com.rest.ejemplo.model.entity.CuentaEntity;
import co.com.rest.ejemplo.model.repository.ICuentaRepository;

@Service
public class CuentaServiceImp implements ICuentaService{
	
	private ICuentaRepository cuentaRepository;

	@Autowired
	public CuentaServiceImp(ICuentaRepository cuentaRepository) {
		this.cuentaRepository = cuentaRepository;
	}

	@Override
	public List<CuentaEntity> findAll() {
		return (List<CuentaEntity>) cuentaRepository.findAll();
	}

	@Override
	public CuentaEntity findById(Long id) {
		return cuentaRepository.findById(id).orElse(null);
	}

	@Override
	public CuentaEntity saveCuenta(CuentaEntity cuenta) {
		return cuentaRepository.save(cuenta);
	}

	@Override
	public void deleteCuenta(Long id) {
		CuentaEntity cuenta = cuentaRepository.findById(id).orElse(null);
		if(cuenta == null) {
			throw new ClienteNoExisteException("La cuenta no se encuentra registrado en el sistema");
		}
		cuentaRepository.deleteById(id);
		
	}

	

}
