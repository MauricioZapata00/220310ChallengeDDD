package pago;

import co.com.sofka.domain.generic.AggregateEvent;
import pago.events.TransferenciaRealizada;
import pago.values.Factura;
import pago.values.PagoId;
import pago.values.Transferencia;

import java.util.Objects;

public class Pago extends AggregateEvent<PagoId> {

    protected Factura factura;
    protected Transferencia transferencia;

    public Pago(PagoId entityId, Factura factura, Transferencia transferencia) {
        super(entityId);
        appendChange(new TransferenciaRealizada(factura, transferencia)).apply();
    }

    private Pago(PagoId entityId){
        super(entityId);
        subscribe(new PagoChange(this));
    }

    public String verFactura(){
        Objects.requireNonNull(this.factura, "No se ha realizado transferencia, por " +
                "tanto no hay factura");
        return this.factura.toString();
    }

    public String verTransferencia(){
        Objects.requireNonNull(this.transferencia, "No se ha realizado transferencia");
        return this.transferencia.toString();
    }

    public Factura Factura() {
        return this.factura;
    }

    public Transferencia Transferencia() {
        return this.transferencia;
    }
}
