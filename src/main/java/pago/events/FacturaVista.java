package pago.events;

import co.com.sofka.domain.generic.DomainEvent;
import pago.values.Factura;

public class FacturaVista extends DomainEvent {

    private final Factura factura;

    public FacturaVista(Factura factura) {
        super("banco.pago.facturaVista");
        this.factura = factura;
    }

    public Factura getFactura() {
        return this.factura;
    }
}
