package pago.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class Factura implements ValueObject<String> {

    private final LocalDateTime fecha;
    private final String lugar;
    private final String nit;
    private Double monto;

    public Factura(Double monto){
        this.fecha = LocalDateTime.now();
        this.lugar = "tienda";
        this.nit = "123456789";
        this.monto = Objects.requireNonNull(monto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factura)) return false;
        Factura factura = (Factura) o;
        return Objects.equals(fecha, factura.fecha) && Objects.equals(lugar, factura.lugar) && Objects.equals(nit, factura.nit) && Objects.equals(monto, factura.monto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, lugar, nit, monto);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                ", nit='" + nit + '\'' +
                ", monto=" + monto +
                '}';
    }

    @Override
    public String value(){
        return this.toString();
    }
}
