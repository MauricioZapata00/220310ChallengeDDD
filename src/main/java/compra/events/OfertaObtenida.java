package compra.events;

import co.com.sofka.domain.generic.DomainEvent;
import compra.Oferta;
import compra.values.Descuento;
import compra.values.OfertaId;
import compra.values.Promocion;

public class OfertaObtenida extends DomainEvent {

    private Oferta oferta;
    public OfertaObtenida(OfertaId entityId, Descuento descuento, Promocion promocion) {
        super("aplicacion.compra.ofertaObtenida");
        this.oferta = new Oferta(entityId, descuento, promocion);
    }

    public Oferta getOferta() {
        return this.oferta;
    }
}
