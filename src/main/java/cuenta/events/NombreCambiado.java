package cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import cuenta.Nombre;
import cuenta.values.NombreId;


public class NombreCambiado extends DomainEvent {

    private Nombre nombre;
    public NombreCambiado(NombreId nombreId, String nombre) {
        super("cliente.cuenta.nombrecambiado");
        this.nombre = new Nombre(nombreId, nombre);
    }

    public Nombre getNombre() {
        return this.nombre;
    }
}
