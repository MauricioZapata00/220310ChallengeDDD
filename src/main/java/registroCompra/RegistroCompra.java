package registroCompra;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import registroCompra.events.OrdenAgregada;
import registroCompra.events.ProductoAgregado;
import registroCompra.events.RegistroAgregado;
import registroCompra.values.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegistroCompra extends AggregateEvent<RegistroCompraId> {

    protected ArrayList<Producto> productos;
    protected ArrayList<Orden> ordenes;
    protected CostoInventario costoInventario;
    protected CompraId compraId;

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

    public void agregarProducto(ProductoId entityId, Descripcion descripcion, Precio precio,
                                Imagen imagen){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(precio);
        Objects.requireNonNull(imagen);
        appendChange(new ProductoAgregado(entityId, descripcion, precio, imagen)).apply();
    }

    public void agregarOrden(OrdenId entityId, Empresa empresa, FechaDespacho fechaDespacho,
                             Entrega entrega){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(empresa);
        Objects.requireNonNull(fechaDespacho);
        Objects.requireNonNull(entrega);
        appendChange(new OrdenAgregada(entityId, empresa, fechaDespacho, entrega)).apply();
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    public ArrayList<Orden> getOrdenes() {
        return this.ordenes;
    }

    public CostoInventario getCostoInventario() {
        return this.costoInventario;
    }

    public CompraId getCompraId() {
        return this.compraId;
    }
}
