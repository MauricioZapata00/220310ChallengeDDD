package cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import cuenta.Direccion;

public class DireccionCambiada extends DomainEvent {

    private Direccion direccion;
    public DireccionCambiada(Direccion direccion) {
        super("cliente.cuenta.direccionCambiada");
        this.direccion = direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
