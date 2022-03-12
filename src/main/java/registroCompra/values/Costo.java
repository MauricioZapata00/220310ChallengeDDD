package registroCompra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Costo implements ValueObject<Double> {

    private final Double valor;

    public Costo(Double valor) {
        this.valor = Objects.requireNonNull(valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Costo)) return false;
        Costo costo = (Costo) o;
        return Objects.equals(valor, costo.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public Double value() {
        return this.valor;
    }
}
