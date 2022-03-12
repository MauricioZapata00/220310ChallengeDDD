package registroCompra.events;

import co.com.sofka.domain.generic.DomainEvent;
import registroCompra.Producto;
import registroCompra.values.Descripcion;
import registroCompra.values.Imagen;
import registroCompra.values.Precio;
import registroCompra.values.ProductoId;


public class ProductoAgregado extends DomainEvent {

    private Producto producto;
    public ProductoAgregado(ProductoId entityId, Descripcion descripcion, Precio precio,
                            Imagen imagen) {
        super("baseDeDatos.registroCompra.productoAgregado");
        this.producto = new Producto(entityId, descripcion, precio, imagen);
    }

    public Producto getProducto() {
        return this.producto;
    }
}
