package registroCompra;

import co.com.sofka.domain.generic.AggregateEvent;
import registroCompra.events.OrdenAgregada;
import registroCompra.events.ProductoAgregado;
import registroCompra.events.RegistroAgregado;
import registroCompra.values.RegistroCompraId;

import java.util.ArrayList;
import java.util.Objects;

public class RegistroCompra extends AggregateEvent<RegistroCompraId> {

    protected ArrayList<Producto> productos;
    protected ArrayList<Orden> ordenes;
    protected CostoInventario costoInventario;

    public RegistroCompra(RegistroCompraId entityId, ArrayList<Producto> productos,
                          ArrayList<Orden> ordenes) {
        super(entityId);
        appendChange(new RegistroAgregado(productos, ordenes)).apply();
    }

    private RegistroCompra(RegistroCompraId entityId){
        super(entityId);
        subscribe(new RegistroCompraChange(this));
    }

    public void agregarProducto(Producto producto){
        Objects.requireNonNull(producto);
        appendChange(new ProductoAgregado(producto)).apply();
    }

    public void agregarOrden(Orden orden){
        Objects.requireNonNull(orden);
        appendChange(new OrdenAgregada(orden)).apply();
    }
}
