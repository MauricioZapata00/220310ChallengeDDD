package compra;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import compra.events.AnuncioCambiado;
import compra.events.CompraHecha;
import compra.events.OfertaObtenida;
import compra.values.*;
import registroCompra.values.RegistroCompraId;

import java.util.List;
import java.util.Objects;

public class Compra extends AggregateEvent<CompraId> {

    protected Oferta oferta;
    protected AnuncioRelacionado anuncioRelacionado;
    protected Descripcion descripcion;
    protected RegistroCompraId registroCompraId;

    public Compra(CompraId entityId, AnuncioRelacionado anuncioRelacionado) {
        super(entityId);
        appendChange(new CompraHecha(anuncioRelacionado)).apply();
    }

    private Compra(CompraId entityId){
        super(entityId);
        subscribe(new CompraChange(this));
    }

    public static Compra from(CompraId entityId, List<DomainEvent> events){
        Compra compra = new Compra(entityId);
        events.forEach(compra::applyEvent);
        return compra;
    }

    public void obtenerOferta(OfertaId entityId, Descuento descuento, Promocion promocion){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(descuento);
        Objects.requireNonNull(promocion);
        appendChange(new OfertaObtenida(entityId, descuento, promocion)).apply();
    }

    public void cambiarAnuncio(AnuncioId entityId, Publicidad publicidad, Cookies cookies){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(publicidad);
        Objects.requireNonNull(cookies);
        appendChange(new AnuncioCambiado(entityId, publicidad, cookies)).apply();
    }

    public Oferta getOferta() {
        return this.oferta;
    }

    public AnuncioRelacionado getAnuncioRelacionado() {
        return this.anuncioRelacionado;
    }

    public Descripcion getDescripcion() {
        return this.descripcion;
    }

    public RegistroCompraId getRegistroCompraId() {
        return this.registroCompraId;
    }
}
