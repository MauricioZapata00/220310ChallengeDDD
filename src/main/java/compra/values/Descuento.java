package compra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descuento implements ValueObject<String> {

    private String porcentaje;

    public Descuento(String porcentaje) {
        this.porcentaje = Objects.requireNonNull(porcentaje);
        if (this.porcentaje.isBlank()){
            throw new IllegalArgumentException("Ingresa un porcentaje no vacío");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Descuento)) return false;
        Descuento descuento = (Descuento) o;
        return Objects.equals(porcentaje, descuento.porcentaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(porcentaje);
    }

    @Override
    public String value() {
        return this.porcentaje;
    }
}
