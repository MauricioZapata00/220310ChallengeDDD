package cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import cuenta.Direccion;
import cuenta.values.DireccionId;

public class DireccionCambiada extends DomainEvent {

    private Direccion direccion;
    public DireccionCambiada(DireccionId direccionId, String direccion) {
        super("cliente.cuenta.direccionCambiada");
        this.direccion = new Direccion(direccionId, direccion);
    }

    public Direccion getDireccion() {
        return this.direccion;
    }
}
