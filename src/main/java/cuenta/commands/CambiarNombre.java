package cuenta.commands;

import co.com.sofka.domain.generic.Command;
import cuenta.values.CuentaId;
import cuenta.values.NombreId;

public class CambiarNombre extends Command {

    private final NombreId nombreId;
    private final String nombre;
    private final CuentaId cuentaId;

    public CambiarNombre(CuentaId entityId, NombreId nombreId, String nombre) {
        this.nombreId = nombreId;
        this.nombre = nombre;
        this.cuentaId = entityId;
    }

    public NombreId getNombreId() {
        return this.nombreId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public CuentaId getCuentaId() {
        return this.cuentaId;
    }
}
