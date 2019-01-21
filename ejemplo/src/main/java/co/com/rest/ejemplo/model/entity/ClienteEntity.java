package co.com.rest.ejemplo.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class ClienteEntity implements Serializable {

	@OneToMany(mappedBy = "cliente")
	private List<CuentaEntity> listaCuentas;

	@Id
	private Long id;

	@NotNull
	private String nombre;
	@NotNull
	private double salario;
	@NotNull
	private double bonificacion;

	@NotNull
	@Column(name = "fecha_ingreso")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIngreso;

	@NotNull
	public boolean activo;

	private static final long serialVersionUID = 1L;

}
