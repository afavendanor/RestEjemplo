package co.com.rest.ejemplo.databuilder;

import co.com.rest.ejemplo.model.entity.CuentaEntity;
import co.com.rest.ejemplo.util.CuentaType;

public class CuentaEntityTestDataBuilder {

	private static final Long ID_CLIENTE = 12345L;
	private static final Long ID_CUENTA = 54321L;
	private static CuentaType TIPO_CUENTA = CuentaType.AHORRO;
	private static double SALDO = 1000;

	private Long idCuenta;
	private Long idCliente;

	private CuentaType tipo;
	private double saldo;

	public CuentaEntityTestDataBuilder() {
		this.idCliente = ID_CLIENTE;
		this.idCuenta = ID_CUENTA;
		this.tipo = TIPO_CUENTA;
		this.saldo = SALDO;
	}

	public CuentaEntityTestDataBuilder conIdCliente(Long idCliente) {
		this.idCliente = idCliente;
		return this;
	}

	public CuentaEntityTestDataBuilder conIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
		return this;
	}

	public CuentaEntityTestDataBuilder conTipoCuenta(CuentaType tipo) {
		this.tipo = tipo;
		return this;
	}

	public CuentaEntityTestDataBuilder conSaldo(double saldo) {
		this.saldo = saldo;
		return this;
	}

	public CuentaEntity build() {
		return new CuentaEntity(this.idCuenta, this.idCliente, this.tipo, this.saldo);
	}

}
