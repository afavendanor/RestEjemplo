package co.com.apirest.testdatabuilder;

import java.util.Date;

import co.com.apirest.model.entities.Cliente;

public class ClienteTestDataBuilder {

	private static final String NOMBRE = "Andres Avendano";
	private static final double SALARIO = 100000;
	private static final double BONIFICACION = 0;
	private static final Date FECHA_INGRESO = new Date();
	private static final boolean ACTIVO = true;

	private String nombre;
	private double salario;
	private double bonificacion;
	private Date fechaIngreso;
	private boolean activo;

	public ClienteTestDataBuilder(String nombre, double salario, double bonificacion, Date fechaIngreso,
			boolean activo) {
		this.nombre = nombre;
		this.salario = salario;
		this.bonificacion = bonificacion;
		this.fechaIngreso = fechaIngreso;
		this.activo = activo;
	}

	public ClienteTestDataBuilder() {
		this.nombre = NOMBRE;
		this.salario = SALARIO;
		this.bonificacion = BONIFICACION;
		this.fechaIngreso = FECHA_INGRESO;
		this.activo = ACTIVO;
	}

	public ClienteTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ClienteTestDataBuilder conSalario(double salario) {
		this.salario = salario;
		return this;
	}

	public ClienteTestDataBuilder conBonificacion(double bonificacion) {
		this.bonificacion = bonificacion;
		return this;
	}

	public ClienteTestDataBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}

	public ClienteTestDataBuilder conActivo(boolean activo) {
		this.activo = activo;
		return this;
	}

	public Cliente build() {
		return new Cliente(this.nombre, this.salario, this.bonificacion, this.fechaIngreso, this.activo);
	}

}
