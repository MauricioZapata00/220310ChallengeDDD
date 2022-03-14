package cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import cuenta.Direccion;
import cuenta.Email;
import cuenta.Nombre;
import cuenta.values.CuentaId;

public class CuentaCreada extends DomainEvent {

    private final Nombre nombre;
    private final Direccion direccion;
    private final Email email;
    private final CuentaId cuentaId;
    public CuentaCreada(CuentaId cuentaId, Nombre nombre, Direccion direccion, Email email) {
        super("cliente.cuenta.cuentaCreada");
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.cuentaId = cuentaId;
    }

    public Nombre getNombre() {
        return this.nombre;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public Email getEmail() {
        return this.email;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
