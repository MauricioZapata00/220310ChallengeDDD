package registroCompra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class FechaDespacho implements ValueObject<String> {

    private LocalDateTime fecha;

    public FechaDespacho() {
        this.fecha = LocalDateTime.now();
    }

    public FechaDespacho(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public FechaDespacho cambiarFechaDespacho(LocalDateTime nuevaFecha){
        Objects.requireNonNull(nuevaFecha);
        return new FechaDespacho(nuevaFecha);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FechaDespacho)) return false;
        FechaDespacho that = (FechaDespacho) o;
        return Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }

    @Override
    public String toString() {
        return "FechaDespacho{" +
                "fecha=" + fecha +
                '}';
    }

    @Override
    public String value() {
        return this.toString();
    }
}
