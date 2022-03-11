package registroCompra.events;

import co.com.sofka.domain.generic.DomainEvent;
import registroCompra.Orden;

public class OrdenAgregada extends DomainEvent {

    private Orden orden;
    public OrdenAgregada(Orden orden) {
        super("baseDeDatos.registroCompra.ordenAgregada");
        this.orden = orden;
    }

    public Orden getOrden() {
        return orden;
    }
}
