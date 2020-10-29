package co.com.apirest.testdatabuilder;

import co.com.apirest.model.entities.Cuenta;
import co.com.apirest.util.CuentaType;

public class CuentaTestDataBuilder {

	private static final Long ID_CUENTA = 5812465844L;
	private static final Long ID_CLIENTE = 548512L;
	private static final CuentaType TIPO_CUENTA = CuentaType.AHORROS;
	private static final double SALDO = 25000000;

	private Long idCuenta;
	private Long idCliente;
	private CuentaType tipo;
	private double saldo;

	public CuentaTestDataBuilder(Long idCuenta, Long idCliente, CuentaType tipo, double saldo) {
		this.idCuenta = idCuenta;
		this.idCliente = idCliente;
		this.tipo = tipo;
		this.saldo = saldo;
	}

	public CuentaTestDataBuilder() {
		this.idCuenta = ID_CUENTA;
		this.idCliente = ID_CLIENTE;
		this.tipo = TIPO_CUENTA;
		this.saldo = SALDO;
	}

	public CuentaTestDataBuilder conIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
		return this;
	}

	public CuentaTestDataBuilder conIdCliente(Long idCliente) {
		this.idCliente = idCliente;
		return this;
	}

	public CuentaTestDataBuilder conCuentaType(CuentaType tipo) {
		this.tipo = tipo;
		return this;
	}

	public CuentaTestDataBuilder conSaldo(double saldo) {
		this.saldo = saldo;
		return this;
	}

	public Cuenta build() {
		return new Cuenta(this.idCuenta, this.idCliente, this.tipo, this.saldo);
	}

}