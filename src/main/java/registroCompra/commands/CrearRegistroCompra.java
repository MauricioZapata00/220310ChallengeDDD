package registroCompra.commands;

import co.com.sofka.domain.generic.Command;
import registroCompra.Orden;
import registroCompra.Producto;
import registroCompra.values.RegistroCompraId;

import java.util.ArrayList;

public class CrearRegistroCompra extends Command {

    private final RegistroCompraId registroCompraId;
    private final ArrayList<Producto> productos;
    private final ArrayList<Orden> ordenes;

    public CrearRegistroCompra(RegistroCompraId registroCompraId, ArrayList<Producto> productos,
                               ArrayList<Orden> ordenes) {
        this.registroCompraId = registroCompraId;
        this.productos = productos;
        this.ordenes = ordenes;
    }

    public RegistroCompraId getRegistroCompraId() {
        return this.registroCompraId;
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    public ArrayList<Orden> getOrdenes() {
        return this.ordenes;
    }
}
