package registroCompra.events;

import co.com.sofka.domain.generic.DomainEvent;
import registroCompra.Orden;
import registroCompra.values.Empresa;
import registroCompra.values.Entrega;
import registroCompra.values.FechaDespacho;
import registroCompra.values.OrdenId;

public class OrdenAgregada extends DomainEvent {

    private Orden orden;
    public OrdenAgregada(OrdenId entityId, Empresa empresa, FechaDespacho fechaDespacho,
                         Entrega entrega) {
        super("baseDeDatos.registroCompra.ordenAgregada");
        this.orden = new Orden(entityId, empresa, fechaDespacho, entrega);
    }

    public Orden getOrden() {
        return this.orden;
    }
}
