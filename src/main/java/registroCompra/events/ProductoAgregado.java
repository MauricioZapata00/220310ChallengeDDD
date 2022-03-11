package registroCompra.events;

import co.com.sofka.domain.generic.DomainEvent;
import registroCompra.Producto;

import java.util.ArrayList;

public class ProductoAgregado extends DomainEvent {

    private Producto producto;
    public ProductoAgregado(Producto producto) {
        super("baseDeDatos.registroCompra.productoAgregado");
        this.producto = producto;
    }

    public Producto getProducto() {
        return this.producto;
    }
}
