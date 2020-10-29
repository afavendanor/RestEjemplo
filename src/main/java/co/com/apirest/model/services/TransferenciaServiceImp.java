package co.com.apirest.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import co.com.apirest.domain.ValidarRetiro;
import co.com.apirest.model.dao.Transferencia;
import co.com.apirest.model.entities.Cuenta;

@Service
public class TransferenciaServiceImp implements ITransferenciaService {

	private ICuentaService cuentaService;
	private final TransactionTemplate transactionTemplate;

	@Value("${valor_maximo_transferencia}")
	private double valorMaximoTransferencia;

	@Autowired
	public TransferenciaServiceImp(ICuentaService cuentaService, PlatformTransactionManager transactionManager) {
		this.cuentaService = cuentaService;
		this.transactionTemplate = new TransactionTemplate(transactionManager);
	}

	@Override
	public Transferencia realizarTransferencia(Transferencia transferencia) {
		ValidarRetiro.validarMontoNegativo(transferencia.getMonto());
		ValidarRetiro.validarMontoTransferencia(transferencia.getMonto(), valorMaximoTransferencia);
		Cuenta cuentaOrigen = cuentaService.findById(transferencia.getIdCuentaOrigen());
		ValidarRetiro.validarSaldoMinimo(cuentaOrigen.getSaldo() - transferencia.getMonto());

		Cuenta cuentaDestino = cuentaService.findById(transferencia.getIdCuentaDestino());
		cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - transferencia.getMonto());
		cuentaDestino.setSaldo(cuentaDestino.getSaldo() + transferencia.getMonto());

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				cuentaService.save(cuentaOrigen);
				cuentaService.save(cuentaDestino);
			}
		});
		
		return transferencia;
	}

}