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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cliente")
public class ClienteEntity implements Serializable {

	@Id
	private Long id;

	@OneToMany(mappedBy = "cliente")
	@JsonIgnoreProperties("cliente")
	private List<CuentaEntity> cuentas;

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

	public ClienteEntity(Long id, String nombre, double salario, double bonificacion, Date fechaIngreso,
			boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.salario = salario;
		this.bonificacion = bonificacion;
		this.fechaIngreso = fechaIngreso;
		this.activo = activo;
	}
	
	public ClienteEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(double bonificacion) {
		this.bonificacion = bonificacion;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<CuentaEntity> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CuentaEntity> cuentas) {
		this.cuentas = cuentas;
	}

	private static final long serialVersionUID = 1L;

}
