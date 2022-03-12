package cuenta.commands;

import co.com.sofka.domain.generic.Command;
import cuenta.values.NombreId;

public class CambiarNombre extends Command {

    private final NombreId nombreId;
    private final String nombre;

    public CambiarNombre(NombreId nombreId, String nombre) {
        this.nombreId = nombreId;
        this.nombre = nombre;
    }

    public NombreId getNombreId() {
        return this.nombreId;
    }

    public String getNombre() {
        return this.nombre;
    }
}
