package pago;

import co.com.sofka.domain.generic.EventChange;
import pago.events.FacturaVista;
import pago.events.TransferenciaRealizada;
import pago.events.TransferenciaVista;

public class PagoChange extends EventChange {
    public PagoChange(Pago pago) {

        apply((TransferenciaRealizada event) -> {
            event.setTransferencia(pago.transferencia);
            event.setFactura(pago.factura);
        });
        apply((FacturaVista event) -> {
            pago.factura = event.getFactura();
        });
        apply((TransferenciaVista event) -> {
            pago.transferencia = event.getTransferencia();
        });
    }
}
