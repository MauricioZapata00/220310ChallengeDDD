package cuenta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import compra.values.CompraId;
import cuenta.events.*;
import cuenta.values.*;


import java.util.ArrayList;
import java.util.List;
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

    public static Cuenta from(CuentaId entityId, List<DomainEvent> events){
        Cuenta cuenta = new Cuenta(entityId);
        events.forEach(cuenta::applyEvent);
        return cuenta;
    }

    public void cambiarNombre(CuentaId entityId, NombreId nombreId, String nombre){
        Objects.requireNonNull(nombreId);
        Objects.requireNonNull(nombre);
        appendChange(new NombreCambiado(entityId, nombreId, nombre)).apply();
    }

    public void cambiarDireccion(DireccionId direccionId, String direccion){
        Objects.requireNonNull(direccionId);
        Objects.requireNonNull(direccion);
        appendChange(new DireccionCambiada(direccionId, direccion)).apply();
    }

    public void cambiarCorreo(EmailId emailId, String email){
        Objects.requireNonNull(emailId);
        Objects.requireNonNull(email);
        appendChange(new CorreoCambiado(emailId, email)).apply();
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
