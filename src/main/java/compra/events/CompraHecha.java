package compra.events;

import co.com.sofka.domain.generic.DomainEvent;
import compra.AnuncioRelacionado;

public class CompraHecha extends DomainEvent {

    private final AnuncioRelacionado anuncioRelacionado;
    
    public CompraHecha(AnuncioRelacionado anuncioRelacionado) {
        super("aplicacion.compra.compraHecha");
        this.anuncioRelacionado = anuncioRelacionado;
    }

    public AnuncioRelacionado getAnuncioRelacionado() {
        return anuncioRelacionado;
    }
}
