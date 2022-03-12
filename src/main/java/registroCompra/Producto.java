package registroCompra;

import co.com.sofka.domain.generic.Entity;
import registroCompra.values.Descripcion;
import registroCompra.values.Imagen;
import registroCompra.values.Precio;
import registroCompra.values.ProductoId;

import java.util.Objects;

public class Producto extends Entity<ProductoId> {

    private Descripcion descripcion;
    private Precio precio;
    private Imagen imagen;

    public Producto(ProductoId entityId, Descripcion descripcion, Precio precio,
                    Imagen imagen) {
        super(entityId);
        this.descripcion = Objects.requireNonNull(descripcion);
        this.precio = Objects.requireNonNull(precio);
        this.imagen = Objects.requireNonNull(imagen);
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Imagen getImagen() {
        return imagen;
    }
}
