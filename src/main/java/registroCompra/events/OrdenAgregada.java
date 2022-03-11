package registroCompra.events;

import co.com.sofka.domain.generic.DomainEvent;

public class OrdenAgregada extends DomainEvent {

    public OrdenAgregada() {
        super("baseDeDatos.registroCompra.ordenAgregada");
        //TODO: Make the process to add order
    }
}
