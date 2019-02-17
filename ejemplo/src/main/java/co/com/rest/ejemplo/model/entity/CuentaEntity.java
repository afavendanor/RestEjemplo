package co.com.rest.ejemplo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.com.rest.ejemplo.util.CuentaType;

@Entity
@Table(name = "cuenta")
public class CuentaEntity implements Serializable {

	@Id
	@Column(name = "id_cuenta")
	private Long idCuenta;
	
	@ManyToOne()
	@JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
	@JsonIgnoreProperties("cuentas")
	private ClienteEntity cliente;

	@Column(name = "id_cliente")
	private Long idCliente;

	@Enumerated(EnumType.STRING)
	private CuentaType tipo;
	@NotNull
	private double saldo;
	
	

	public CuentaEntity(Long idCuenta, Long idCliente, CuentaType tipo, double saldo) {
		this.idCuenta = idCuenta;
		this.idCliente = idCliente;
		this.tipo = tipo;
		this.saldo = saldo;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public CuentaType getTipo() {
		return tipo;
	}

	public void setTipo(CuentaType tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	private static final long serialVersionUID = 1L;

}
