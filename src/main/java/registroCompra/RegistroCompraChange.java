package registroCompra;

import co.com.sofka.domain.generic.EventChange;
import registroCompra.events.OrdenAgregada;
import registroCompra.events.ProductoAgregado;
import registroCompra.events.RegistroAgregado;

public class RegistroCompraChange extends EventChange {
    public RegistroCompraChange(RegistroCompra registroCompra) {
        apply((RegistroAgregado event) -> {
            registroCompra.ordenes = event.getOrdenes();
            registroCompra.productos = event.getProductos();
        });
        apply((ProductoAgregado event) -> {
            Producto productoParaAgregar = event.getProducto();
            registroCompra.productos.add(productoParaAgregar);
        });
        apply((OrdenAgregada event) -> {
            Orden ordenParaAgregar = event.getOrden();
            registroCompra.ordenes.add(ordenParaAgregar);
        });
    }
}
