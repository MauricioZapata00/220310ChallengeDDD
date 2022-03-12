package cuenta.commands;

import co.com.sofka.domain.generic.Command;
import cuenta.values.DireccionId;

public class CambiarDIreccion extends Command {

    private final DireccionId direccionId;
    private final String direccion;

    public CambiarDIreccion(DireccionId direccionId, String direccion) {
        this.direccionId = direccionId;
        this.direccion = direccion;
    }

    public DireccionId getDireccionId() {
        return this.direccionId;
    }

    public String getDireccion() {
        return this.direccion;
    }
}
