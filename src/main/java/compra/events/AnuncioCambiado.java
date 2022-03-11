package compra.events;

import co.com.sofka.domain.generic.DomainEvent;
import compra.AnuncioRelacionado;

public class AnuncioCambiado extends DomainEvent {

    private AnuncioRelacionado anuncioRelacionado;
    public AnuncioCambiado(AnuncioRelacionado anuncioRelacionado) {
        super("aplicacion.compra.anuncioCambiado");
        this.anuncioRelacionado = anuncioRelacionado;
    }

    public void setAnuncioRelacionado(AnuncioRelacionado anuncioRelacionado) {
        this.anuncioRelacionado = anuncioRelacionado;
    }
}
