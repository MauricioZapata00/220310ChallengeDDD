package registroCompra;

import co.com.sofka.domain.generic.Entity;
import registroCompra.values.Costo;
import registroCompra.values.CostoInventarioId;
import registroCompra.values.Fecha;

public class CostoInventario extends Entity<CostoInventarioId> {

    private Costo costo;
    private Fecha fecha;

    public CostoInventario(CostoInventarioId entityId, Costo costo, Fecha fecha) {
        super(entityId);
        this.costo = costo;
        this.fecha = fecha;
    }

    public Costo getCosto() {
        return this.costo;
    }

    public Fecha getFecha() {
        return this.fecha;
    }
}
