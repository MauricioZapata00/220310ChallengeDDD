package compra.events;

import co.com.sofka.domain.generic.DomainEvent;
import compra.Oferta;

public class OfertaObtenida extends DomainEvent {

    private Oferta oferta;
    public OfertaObtenida(Oferta oferta) {
        super("aplicacion.compra.ofertaObtenida");
        this.oferta = oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }
}
