package cuenta.commands;

import co.com.sofka.domain.generic.Command;
import cuenta.values.MetodoDePago;

public class AsociarMetodoDePago extends Command {

    private final MetodoDePago metodoDePago;

    public AsociarMetodoDePago(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public MetodoDePago getMetodoDePago() {
        return this.metodoDePago;
    }
}
