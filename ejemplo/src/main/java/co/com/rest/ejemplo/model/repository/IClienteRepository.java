package co.com.rest.ejemplo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.rest.ejemplo.model.entity.ClienteEntity;

public interface IClienteRepository extends CrudRepository<ClienteEntity, Long>{
	
	@Query("select v from ClienteEntity v where v.activo = TRUE")
	public List<ClienteEntity> findActive();

}
