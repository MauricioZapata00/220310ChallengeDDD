package pago.commands;

import co.com.sofka.domain.generic.Command;
import pago.values.PagoId;

public class VerFactura extends Command {

    private final PagoId pagoId;

    public VerFactura(PagoId pagoId) {
        this.pagoId = pagoId;
    }

    public PagoId getPagoId() {
        return this.pagoId;
    }
}
