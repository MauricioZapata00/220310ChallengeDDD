package registroCompra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {

    private final String informacion;

    public Descripcion(String informacion) {
        this.informacion = Objects.requireNonNull(informacion);
        if (this.informacion.isBlank()){
            throw new IllegalArgumentException("Ingresa una información que no sea vacía");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Descripcion)) return false;
        Descripcion that = (Descripcion) o;
        return Objects.equals(informacion, that.informacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informacion);
    }

    @Override
    public String value() {
        return this.informacion;
    }
}
