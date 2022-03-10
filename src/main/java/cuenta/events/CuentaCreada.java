package cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import cuenta.Direccion;
import cuenta.Email;
import cuenta.Nombre;

public class CuentaCreada extends DomainEvent {

    private final Nombre nombre;
    private final Direccion direccion;
    private final Email email;
    public CuentaCreada(Nombre nombre, Direccion direccion, Email email) {
        super("cliente.cuenta.cuentaCreada");
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
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
}
