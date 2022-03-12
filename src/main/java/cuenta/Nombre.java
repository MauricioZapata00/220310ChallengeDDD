package cuenta;

import co.com.sofka.domain.generic.Entity;
import cuenta.values.NombreId;

import java.util.Objects;

public class Nombre extends Entity<NombreId> {

    private String nombre;
    public Nombre(NombreId entityId, String nombre) {
        super(entityId);
        this.nombre = Objects.requireNonNull(nombre);
        if(this.nombre.isBlank()){
            throw new IllegalArgumentException("Se debe ingresar un nombre que no sea vacío");
        }
    }


    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if(this.nombre.isBlank()){
            throw new IllegalArgumentException("Se debe ingresar un nombre que no sea vacío");
        }
    }
}
