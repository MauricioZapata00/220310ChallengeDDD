package registroCompra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Double> {

    private Double valor;

    public Precio(Double valor) {
        this.valor = Objects.requireNonNull(valor);
    }

    public Precio cambiarPrecio(Double nuevoPrecio){
        Objects.requireNonNull(nuevoPrecio);
        return new Precio(nuevoPrecio);
    }

    @Override
    public Double value() {
        return null;
    }
}
