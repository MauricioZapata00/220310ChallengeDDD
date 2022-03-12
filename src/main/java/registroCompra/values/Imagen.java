package registroCompra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Imagen implements ValueObject<String> {

    private String direccionImagen;

    public Imagen(String direccionImagen) {
        this.direccionImagen = Objects.requireNonNull(direccionImagen);
        if (this.direccionImagen.isBlank()){
            throw new IllegalArgumentException("Ingresa una dirección de imagen no vacía");
        }
    }

    public Imagen cambiarDireccionImagen(String nuevaDireccion){
        Objects.requireNonNull(nuevaDireccion);
        return new Imagen(nuevaDireccion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Imagen)) return false;
        Imagen imagen = (Imagen) o;
        return Objects.equals(direccionImagen, imagen.direccionImagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccionImagen);
    }

    @Override
    public String value() {
        return this.direccionImagen;
    }
}
