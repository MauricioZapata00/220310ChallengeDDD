package pago.events;

import co.com.sofka.domain.generic.DomainEvent;
import pago.values.Transferencia;

public class TransferenciaVista extends DomainEvent {

    private final Transferencia transferencia;
    public TransferenciaVista(Transferencia transferencia) {
        super("banco.pago.transferenciaVista");
        this.transferencia = transferencia;
    }

    public Transferencia getTransferencia() {
        return this.transferencia;
    }
}
