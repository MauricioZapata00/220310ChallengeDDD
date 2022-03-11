package registroCompra;

import co.com.sofka.domain.generic.Entity;
import registroCompra.values.ProductoId;

public class Producto extends Entity<ProductoId> {

    public Producto(ProductoId entityId) {
        super(entityId);
    }
}
