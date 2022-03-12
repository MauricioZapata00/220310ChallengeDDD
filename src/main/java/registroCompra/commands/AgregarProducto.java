package registroCompra.commands;

import co.com.sofka.domain.generic.Command;
import registroCompra.values.Descripcion;
import registroCompra.values.Imagen;
import registroCompra.values.Precio;
import registroCompra.values.ProductoId;

public class AgregarProducto extends Command {

    private final ProductoId productoId;
    private final Descripcion descripcion;
    private final Precio precio;
    private final Imagen imagen;

    public AgregarProducto(ProductoId productoId, Descripcion descripcion,
                           Precio precio, Imagen imagen) {
        this.productoId = productoId;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public ProductoId getProductoId() {
        return this.productoId;
    }

    public Descripcion getDescripcion() {
        return this.descripcion;
    }

    public Precio getPrecio() {
        return this.precio;
    }

    public Imagen getImagen() {
        return this.imagen;
    }
}
