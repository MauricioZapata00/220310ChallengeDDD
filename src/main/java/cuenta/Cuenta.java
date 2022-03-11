package cuenta;

import co.com.sofka.domain.generic.AggregateEvent;
import compra.values.CompraId;
import cuenta.events.*;
import cuenta.values.CuentaId;
import cuenta.values.MetodoDePago;
import cuenta.values.PagoId;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

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

    private Cuenta(CuentaId entityId){
        super(entityId);
        subscribe(new CuentaChange(this));
    }

    public void cambiarNombre(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreCambiado(nombre)).apply();
    }

    public void cambiarDireccion(Direccion direccion){
        Objects.requireNonNull(direccion);
        appendChange(new DireccionCambiada(direccion)).apply();
    }

    public void cambiarCorreo(Email email){
        Objects.requireNonNull(email);
        appendChange(new CorreoCambiado(email)).apply();
    }

    public void asociarMetodoDePago(MetodoDePago metodoDePago){
        Objects.requireNonNull(metodoDePago);
        appendChange(new MetodoDePagoAsociado(metodoDePago)).apply();
    }

    public Optional<PagoId> getPagoPorId(PagoId pagoId){
        Objects.requireNonNull(pagoId);
        return this.pagoIds.stream().findFirst();
    }

    public Optional<CompraId> getCompraPorId(CompraId compraId){
        Objects.requireNonNull(compraId);
        return this.compraIds.stream().findFirst();
    }

    public Nombre Nombre() {
        return this.nombre;
    }

    public Direccion Direccion() {
        return this.direccion;
    }

    public Email Email() {
        return this.email;
    }

    public ArrayList<PagoId> PagoIds() {
        return this.pagoIds;
    }

    public ArrayList<CompraId> CompraIds() {
        return this.compraIds;
    }
}
