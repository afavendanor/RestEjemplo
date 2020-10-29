package co.com.apirest.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.apirest.model.entities.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {

	@Query("SELECT c.activo FROM Cliente c WHERE c.id = :id")
	public boolean isActive(@Param("id") Long id);

}
