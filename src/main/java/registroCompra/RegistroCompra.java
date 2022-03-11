package registroCompra;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import registroCompra.events.OrdenAgregada;
import registroCompra.events.ProductoAgregado;
import registroCompra.events.RegistroAgregado;
import registroCompra.values.RegistroCompraId;

import java.util.ArrayList;
import java.util.List;
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

    public static RegistroCompra from(RegistroCompraId entityId, List<DomainEvent> events){
        RegistroCompra registroCompra = new RegistroCompra(entityId);
        events.forEach(registroCompra::applyEvent);
        return registroCompra;
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
