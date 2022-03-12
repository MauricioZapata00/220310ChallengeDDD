package registroCompra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Entrega implements ValueObject<Boolean> {

    private Boolean entregada;

    public Entrega(Boolean entregada) {
        this.entregada = Objects.requireNonNull(entregada);
    }

    public Entrega cambiarEstadoEntrega(Boolean estado){
        Objects.requireNonNull(estado);
        return new Entrega(estado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entrega)) return false;
        Entrega entrega = (Entrega) o;
        return Objects.equals(entregada, entrega.entregada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entregada);
    }

    @Override
    public Boolean value() {
        return this.entregada;
    }
}
