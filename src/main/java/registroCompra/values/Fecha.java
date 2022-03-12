package registroCompra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class Fecha implements ValueObject<String> {

    private LocalDateTime fecha;

    public Fecha() {
        this.fecha = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fecha)) return false;
        Fecha fecha1 = (Fecha) o;
        return Objects.equals(fecha, fecha1.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "fecha=" + fecha +
                '}';
    }

    @Override
    public String value() {
        return this.toString();
    }
}
