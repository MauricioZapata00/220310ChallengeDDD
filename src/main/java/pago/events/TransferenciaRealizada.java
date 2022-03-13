package pago.events;

import co.com.sofka.domain.generic.DomainEvent;
import pago.values.Factura;
import pago.values.Transferencia;

public class TransferenciaRealizada extends DomainEvent {

    private Factura factura;
    private Transferencia transferencia;
    public TransferenciaRealizada(Factura factura, Transferencia transferencia) {
        super("banco.pago.transferenciaRealizada");
        this.factura = factura;
        this.transferencia = transferencia;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    public Factura getFactura() {
        return this.factura;
    }

    public Transferencia getTransferencia() {
        return this.transferencia;
    }
}
