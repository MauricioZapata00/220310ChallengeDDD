package compra;

import co.com.sofka.domain.generic.AggregateEvent;
import compra.values.CompraId;
import registroCompra.values.RegistroCompraId;

public class Compra extends AggregateEvent<CompraId> {

    protected Oferta oferta;
    protected AnuncioRelacionado anuncioRelacionado;
    protected Descripcion descripcion;
    protected RegistroCompraId registroCompraId;
    public Compra(CompraId entityId, AnuncioRelacionado anuncioRelacionado) {
        super(entityId);
    }
}
