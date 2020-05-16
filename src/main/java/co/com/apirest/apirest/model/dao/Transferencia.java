package co.com.apirest.apirest.model.dao;

import javax.validation.constraints.NotNull;

public class Transferencia {

	@NotNull
	private Long idCuentaOrigen;
	@NotNull
	private Long idCuentaDestino;
	@NotNull
	private double monto;

	public Long getIdCuentaOrigen() {
		return idCuentaOrigen;
	}

	public void setIdCuentaOrigen(Long idCuentaOrigen) {
		this.idCuentaOrigen = idCuentaOrigen;
	}

	public Long getIdCuentaDestino() {
		return idCuentaDestino;
	}

	public void setIdCuentaDestino(Long idCuentaDestino) {
		this.idCuentaDestino = idCuentaDestino;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}