package cuenta;

import co.com.sofka.domain.generic.AggregateEvent;
import compra.values.CompraId;
import cuenta.events.CuentaCreada;
import cuenta.values.CuentaId;
import cuenta.values.MetodoDePago;
import cuenta.values.PagoId;

import java.util.ArrayList;

public class Cuenta extends AggregateEvent<CuentaId> {

    protected Nombre nombre;
    protected Direccion direccion;
    protected Email email;
    protected MetodoDePago metodoDePago;
    protected ArrayList<PagoId> pagoIds;
    protected ArrayList<CompraId> compraIds;

    public Cuenta(CuentaId entityId, Nombre nombre, Direccion direccion, Email email) {
        super(entityId);
        appendChange(new CuentaCreada(nombre, direccion, email)).apply();
    }
}
