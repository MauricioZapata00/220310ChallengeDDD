package registroCompra;

import co.com.sofka.domain.generic.Entity;
import registroCompra.values.Empresa;
import registroCompra.values.Entrega;
import registroCompra.values.FechaDespacho;
import registroCompra.values.OrdenId;

import java.util.Objects;

public class Orden extends Entity<OrdenId> {

    private Empresa empresa;
    private FechaDespacho fechaDespacho;
    private Entrega entregada;

    public Orden(OrdenId entityId, Empresa empresa, FechaDespacho fechaDespacho,
                 Entrega entrega) {
        super(entityId);
        this.empresa = Objects.requireNonNull(empresa);
        this.fechaDespacho = Objects.requireNonNull(fechaDespacho);
        this.entregada = Objects.requireNonNull(entrega);
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public FechaDespacho getFechaDespacho() {
        return this.fechaDespacho;
    }

    public Entrega getEntregada() {
        return this.entregada;
    }
}
