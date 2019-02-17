package co.com.rest.ejemplo.databuilder;

import java.util.Calendar;
import java.util.Date;

import co.com.rest.ejemplo.model.entity.ClienteEntity;

public class ClienteEntityTestDataBuilder {

	private static final Long ID_CLIENTE = 12345L;
	private static final String NOMBRE_CLIENTE = "Andres Avendano";
	private static double SALARIO = 1000;
	private static double BONIFICACION = 100;;

	private Long id;
	private String nombre;
	private double salario;
	private double bonificacion;
	private Date fechaIngreso;
	public boolean activo;

	public ClienteEntityTestDataBuilder() {
		this.id = ID_CLIENTE;
		this.nombre = NOMBRE_CLIENTE;
		this.salario = SALARIO;
		this.bonificacion = BONIFICACION;
		Date fechaSolicitud = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaSolicitud);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) - 2);
		this.fechaIngreso = calendar.getTime();
		this.activo = true;
	}

	public ClienteEntityTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ClienteEntityTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ClienteEntityTestDataBuilder conSalario(double salario) {
		this.salario = salario;
		return this;
	}

	public ClienteEntityTestDataBuilder conBonificacion(double bonificacion) {
		this.bonificacion = bonificacion;
		return this;
	}

	public ClienteEntityTestDataBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public ClienteEntityTestDataBuilder conActivo(boolean activo) {
		this.activo = activo;
		return this;
	}

	public ClienteEntity build() {
		return new ClienteEntity(this.id, this.nombre, this.salario, this.bonificacion, this.fechaIngreso, this.activo);
	}

}
