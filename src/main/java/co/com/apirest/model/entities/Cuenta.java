package co.com.apirest.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import co.com.apirest.util.CuentaType;

@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cuenta;

	@Column(name = "id_cliente")
	private Long idCliente;

	@Enumerated(EnumType.STRING)
	private CuentaType tipo;

	@NotNull
	private double saldo;

	
	public Cuenta() {
	}

	public Cuenta(Long id_cuenta, Long idCliente, CuentaType tipo, double saldo) {
		this.id_cuenta = id_cuenta;
		this.idCliente = idCliente;
		this.tipo = tipo;
		this.saldo = saldo;
	}

	public Long getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
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

}