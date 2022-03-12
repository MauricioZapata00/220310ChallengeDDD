package compra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Publicidad implements ValueObject<String> {

    private final String direccionImagen;
    private final String informacion;

    public Publicidad(String direccionImagen, String informacion) {
        this.direccionImagen = Objects.requireNonNull(direccionImagen);
        this.informacion = Objects.requireNonNull(informacion);
        if (this.informacion.isBlank()){
            throw new IllegalArgumentException("Ingresa una información para tu publicidad");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publicidad)) return false;
        Publicidad that = (Publicidad) o;
        return Objects.equals(direccionImagen, that.direccionImagen) && Objects.equals(informacion, that.informacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccionImagen, informacion);
    }

    @Override
    public String toString() {
        return "Publicidad{" +
                "direccionImagen='" + direccionImagen + '\'' +
                ", informacion='" + informacion + '\'' +
                '}';
    }

    @Override
    public String value() {
        return this.toString();
    }
}
