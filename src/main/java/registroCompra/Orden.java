package registroCompra;

import co.com.sofka.domain.generic.Entity;
import registroCompra.values.OrdenId;

public class Orden extends Entity<OrdenId> {

    public Orden(OrdenId entityId) {
        super(entityId);
    }
}
