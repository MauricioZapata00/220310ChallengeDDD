package compra.events;

import co.com.sofka.domain.generic.DomainEvent;
import compra.AnuncioRelacionado;
import compra.values.AnuncioId;
import compra.values.Cookies;
import compra.values.Publicidad;

public class AnuncioCambiado extends DomainEvent {

    private AnuncioRelacionado anuncioRelacionado;
    public AnuncioCambiado(AnuncioId entityId, Publicidad publicidad, Cookies cookies) {
        super("aplicacion.compra.anuncioCambiado");
        this.anuncioRelacionado = new AnuncioRelacionado(entityId, publicidad, cookies);
    }

    public AnuncioRelacionado getAnuncioRelacionado() {
        return this.anuncioRelacionado;
    }
}
