package registroCompra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Empresa implements ValueObject<String> {

    private final String nombre;

    public Empresa(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if (this.nombre.isBlank()){
            throw new IllegalArgumentException("Ingresa un nombre de empresa no vacío");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa)) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(nombre, empresa.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String value() {
        return this.nombre;
    }
}
