package compra.commands;

import co.com.sofka.domain.generic.Command;
import compra.values.Descuento;
import compra.values.OfertaId;
import compra.values.Promocion;

public class ObtenerOferta extends Command {

    private final OfertaId ofertaId;
    private final Descuento descuento;
    private final Promocion promocion;

    public ObtenerOferta(OfertaId ofertaId, Descuento descuento, Promocion promocion) {
        this.ofertaId = ofertaId;
        this.descuento = descuento;
        this.promocion = promocion;
    }

    public OfertaId getOfertaId() {
        return this.ofertaId;
    }

    public Descuento getDescuento() {
        return this.descuento;
    }

    public Promocion getPromocion() {
        return this.promocion;
    }
}
