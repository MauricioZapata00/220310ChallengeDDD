package registroCompra;

import co.com.sofka.domain.generic.AggregateEvent;
import registroCompra.values.RegistroCompraId;

import java.util.ArrayList;

public class RegistroCompra extends AggregateEvent<RegistroCompraId> {

    protected ArrayList<Producto> productos;
    protected ArrayList<Orden> ordenes;
    protected CostoInventario costoInventario;
    public RegistroCompra(RegistroCompraId entityId, ArrayList<Producto> productos,
                          ArrayList<Orden> ordenes) {
        super(entityId);
    }
}
