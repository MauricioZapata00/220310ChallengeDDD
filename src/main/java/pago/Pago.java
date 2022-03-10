package pago;

import co.com.sofka.domain.generic.AggregateEvent;
import pago.events.TransferenciaRealizada;
import pago.values.Factura;
import pago.values.PagoId;
import pago.values.Transferencia;

public class Pago extends AggregateEvent<PagoId> {

    protected Factura factura;
    protected Transferencia transferencia;
    public Pago(PagoId entityId, Factura factura, Transferencia transferencia) {
        super(entityId);
        appendChange(new TransferenciaRealizada(factura, transferencia)).apply();
    }
}
