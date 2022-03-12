package compra;

import co.com.sofka.domain.generic.EventChange;
import compra.events.AnuncioCambiado;
import compra.events.CompraHecha;
import compra.events.OfertaObtenida;

public class CompraChange extends EventChange {
    public CompraChange(Compra compra) {
        apply((CompraHecha event) -> {
            compra.anuncioRelacionado = event.getAnuncioRelacionado();
        });
        apply((AnuncioCambiado event) -> {
            compra.anuncioRelacionado = event.getAnuncioRelacionado();
        });
        apply((OfertaObtenida event) -> {
            compra.oferta = event.getOferta();
        });
    }
}
