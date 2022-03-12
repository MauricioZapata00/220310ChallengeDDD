package compra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Promocion implements ValueObject<String> {

    private final String tipo;
    private final Double cantidadUmbral;

    public Promocion(String tipo, Double cantidadUmbral) {
        this.tipo = Objects.requireNonNull(tipo);
        if (this.tipo.isBlank()){
            throw new IllegalArgumentException("Ingresa una promoción que no sea vacía");
        }
        this.cantidadUmbral = Objects.requireNonNull(cantidadUmbral);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Promocion)) return false;
        Promocion promocion = (Promocion) o;
        return Objects.equals(tipo, promocion.tipo) && Objects.equals(cantidadUmbral, promocion.cantidadUmbral);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, cantidadUmbral);
    }

    @Override
    public String toString() {
        return "Promocion{" +
                "tipo='" + tipo + '\'' +
                ", cantidadUmbral=" + cantidadUmbral +
                '}';
    }

    @Override
    public String value() {
        return this.toString();
    }
}
