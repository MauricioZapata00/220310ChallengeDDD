package registroCompra.commands;

import co.com.sofka.domain.generic.Command;
import registroCompra.values.Empresa;
import registroCompra.values.Entrega;
import registroCompra.values.FechaDespacho;
import registroCompra.values.OrdenId;

public class AgregarOrden extends Command {

    private final OrdenId ordenId;
    private final Empresa empresa;
    private final FechaDespacho fechaDespacho;
    private final Entrega entrega;

    public AgregarOrden(OrdenId ordenId, Empresa empresa,
                        FechaDespacho fechaDespacho, Entrega entrega) {
        this.ordenId = ordenId;
        this.empresa = empresa;
        this.fechaDespacho = fechaDespacho;
        this.entrega = entrega;
    }

    public OrdenId getOrdenId() {
        return this.ordenId;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public FechaDespacho getFechaDespacho() {
        return this.fechaDespacho;
    }

    public Entrega getEntrega() {
        return this.entrega;
    }
}
