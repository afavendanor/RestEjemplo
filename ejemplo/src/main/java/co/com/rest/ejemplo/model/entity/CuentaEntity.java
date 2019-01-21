package co.com.rest.ejemplo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "cuenta")
public class CuentaEntity implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	private ClienteEntity cliente;
	
	@Column(name = "cliente_id")
	private Long idCliente;
	
	@Id
	@Column(name = "cuenta_id")
	private String idCuenta;
	
	@NotNull
	//@Enumerated(EnumType.STRING)
	private String tipo;
	@NotNull
	private double saldo;

	private static final long serialVersionUID = 1L;

}
