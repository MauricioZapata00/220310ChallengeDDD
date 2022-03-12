package cuenta.commands;

import co.com.sofka.domain.generic.Command;
import cuenta.Direccion;
import cuenta.Email;
import cuenta.Nombre;
import cuenta.values.CuentaId;

public class CrearCuenta extends Command {

    private final CuentaId cuentaId;
    private final Nombre nombre;
    private final Direccion direccion;
    private final Email email;

    public CrearCuenta(CuentaId cuentaId, Nombre nombre, Direccion direccion, Email email) {
        this.cuentaId = cuentaId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
    }

    public CuentaId getCuentaId() {
        return this.cuentaId;
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
