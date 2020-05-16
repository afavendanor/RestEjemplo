package co.com.apirest.apirest.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.apirest.apirest.model.entities.Cuenta;

public interface ICuentaRepository extends CrudRepository<Cuenta, Long>{
	

}
