package registroCompra.events;

import co.com.sofka.domain.generic.DomainEvent;
import registroCompra.Orden;
import registroCompra.Producto;

import java.util.ArrayList;

public class RegistroAgregado extends DomainEvent {

    private ArrayList<Producto> productos;
    private ArrayList<Orden> ordenes;

    public RegistroAgregado(ArrayList<Producto> productos, ArrayList<Orden> ordenes) {
        super("baseDeDatos.registroCompras.registroAgregado");
        this.productos = productos;
        this.ordenes = ordenes;
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    public ArrayList<Orden> getOrdenes() {
        return this.ordenes;
    }
}
