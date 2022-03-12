package pago.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.Random;

public class Transferencia implements ValueObject<String> {
    private String cuentaOrigen;
    private String cuentaDestino;
    private Double monto;
    private final Long idComprobante;
    public Transferencia(String cuentaOrigen, String cuentaDestino, Double monto){
        this.cuentaOrigen = Objects.requireNonNull(cuentaOrigen);
        this.cuentaDestino = Objects.requireNonNull(cuentaDestino);
        this.monto = Objects.requireNonNull(monto);
        this.idComprobante = new Random().nextLong();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transferencia)) return false;
        Transferencia that = (Transferencia) o;
        return Objects.equals(cuentaOrigen, that.cuentaOrigen) && Objects.equals(cuentaDestino, that.cuentaDestino) && Objects.equals(monto, that.monto) && Objects.equals(idComprobante, that.idComprobante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuentaOrigen, cuentaDestino, monto, idComprobante);
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "cuentaOrigen='" + cuentaOrigen + '\'' +
                ", cuentaDestino='" + cuentaDestino + '\'' +
                ", monto=" + monto +
                ", idComprobante=" + idComprobante +
                '}';
    }

    @Override
    public String value() {
        return this.toString();
    }
}
