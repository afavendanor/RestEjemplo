package co.com.rest.ejemplo.model.service;

import java.util.List;

import co.com.rest.ejemplo.model.entity.CuentaEntity;

public interface ICuentaService{
	
public List<CuentaEntity> findAll();
	
	public CuentaEntity findById(Long id);

    public CuentaEntity saveCuenta(CuentaEntity cuenta);

    void deleteCuenta(Long id);

}
