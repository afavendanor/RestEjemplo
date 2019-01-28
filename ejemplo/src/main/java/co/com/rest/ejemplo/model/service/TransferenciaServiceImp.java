package co.com.rest.ejemplo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import co.com.rest.ejemplo.domain.ValidarRetiro;
import co.com.rest.ejemplo.model.dao.Transferencia;
import co.com.rest.ejemplo.model.entity.CuentaEntity;

@Service
public class TransferenciaServiceImp implements ITransferenciaService {

	private ICuentaService cuentaService;
	private final TransactionTemplate transactionTemplate;

	@Autowired
	public TransferenciaServiceImp(ICuentaService cuentaService, PlatformTransactionManager transactionManager) {
		this.cuentaService = cuentaService;
		this.transactionTemplate = new TransactionTemplate(transactionManager);
	}

	@Override
	public void realizarTransferencia(Transferencia transferencia) {
		ValidarRetiro.validarMonto(transferencia.getMonto());
		CuentaEntity cuentaOrigen = cuentaService.findById(transferencia.getIdCuentaOrigen());
		ValidarRetiro.validarSaldoMinimo(cuentaOrigen.getSaldo() - transferencia.getMonto());

		CuentaEntity cuentaDestino = cuentaService.findById(transferencia.getIdCuentaDestino());
		cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - transferencia.getMonto());
		cuentaDestino.setSaldo(cuentaDestino.getSaldo() + transferencia.getMonto());

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				cuentaService.saveCuenta(cuentaOrigen);
				cuentaService.saveCuenta(cuentaDestino);
			}
		});
	}
}
