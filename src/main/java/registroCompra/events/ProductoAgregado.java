package registroCompra.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ProductoAgregado extends DomainEvent {

    public ProductoAgregado() {
        super("baseDeDatos.registroCompra.productoAgregado");
        //TODO: Make the process to add product
    }
}
