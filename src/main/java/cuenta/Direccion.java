package cuenta;

import co.com.sofka.domain.generic.Entity;
import cuenta.values.DireccionId;

import java.util.Objects;

public class Direccion extends Entity<DireccionId> {

    private String direccion;
    public Direccion(DireccionId entityId, String direccion) {
        super(entityId);
        this.direccion = Objects.requireNonNull(direccion);
        if(this.direccion.isBlank()){
            throw new IllegalArgumentException("Ingresa una dirección que no sea vacía");
        }
    }

    public void setDireccion(String direccion) {
        this.direccion = Objects.requireNonNull(direccion);
        if(this.direccion.isBlank()){
            throw new IllegalArgumentException("Ingresa una dirección que no sea vacía");
        }
    }
}
