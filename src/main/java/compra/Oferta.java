package compra;

import co.com.sofka.domain.generic.Entity;
import compra.values.Descuento;
import compra.values.OfertaId;
import compra.values.Promocion;

public class Oferta extends Entity<OfertaId> {


    private Descuento descuento;
    private Promocion promocion;

    public Oferta(OfertaId entityId, Descuento descuento, Promocion promocion) {
        super(entityId);
        this.descuento = descuento;
        this.promocion = promocion;
    }
}
