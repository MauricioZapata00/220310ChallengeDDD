package pago.commands;

import co.com.sofka.domain.generic.Command;
import pago.values.PagoId;

public class VerTransferencia extends Command {

    private final PagoId pagoId;

    public VerTransferencia(PagoId pagoId) {
        this.pagoId = pagoId;
    }

    public PagoId getPagoId() {
        return this.pagoId;
    }
}
