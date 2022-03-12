package cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MetodoDePago implements ValueObject<String> {

    private String tipo;
    private final Long identificador;

    public MetodoDePago(String tipo, Long identificador) {
        this.tipo = Objects.requireNonNull(tipo);
        if(this.tipo.isBlank()){
            throw new IllegalArgumentException("Ingresa un tipo que no sea vacío");
        }
        this.identificador = Objects.requireNonNull(identificador);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetodoDePago)) return false;
        MetodoDePago that = (MetodoDePago) o;
        return Objects.equals(tipo, that.tipo) && Objects.equals(identificador, that.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, identificador);
    }

    @Override
    public String toString() {
        return "MetodoDePago{" +
                "tipo='" + tipo + '\'' +
                ", identificador=" + identificador +
                '}';
    }

    @Override
    public String value() {
        return this.toString();
    }
}
