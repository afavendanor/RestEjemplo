package co.com.rest.ejemplo.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.rest.ejemplo.model.entity.CuentaEntity;

public interface ICuentaRepository extends CrudRepository<CuentaEntity, Long>{

}
