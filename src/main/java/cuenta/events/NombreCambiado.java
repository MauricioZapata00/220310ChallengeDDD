package cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import cuenta.Nombre;

public class NombreCambiado extends DomainEvent {

    private Nombre nombre;
    public NombreCambiado(Nombre nombre) {
        super("cliente.cuenta.nombreCambiado");
        this.nombre = nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }
}
