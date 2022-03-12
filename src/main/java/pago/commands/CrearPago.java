package pago.commands;

import co.com.sofka.domain.generic.Command;
import pago.values.Factura;
import pago.values.PagoId;
import pago.values.Transferencia;

public class CrearPago extends Command {

    private final PagoId pagoId;
    private final Factura factura;
    private final Transferencia transferencia;

    public CrearPago(PagoId pagoId, Factura factura, Transferencia transferencia) {
        this.pagoId = pagoId;
        this.factura = factura;
        this.transferencia = transferencia;
    }

    public PagoId getPagoId() {
        return this.pagoId;
    }

    public Factura getFactura() {
        return this.factura;
    }

    public Transferencia getTransferencia() {
        return this.transferencia;
    }
}
