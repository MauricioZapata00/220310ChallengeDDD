package cuenta;

import co.com.sofka.domain.generic.Entity;
import cuenta.values.CuentaId;
import cuenta.values.NombreId;

import java.util.Objects;

public class Nombre extends Entity<NombreId> {

    private String nombre;
    private NombreId nombreId;
    private CuentaId cuentaId;
    public Nombre(CuentaId cuentaId, NombreId entityId, String nombre) {
        super(entityId);
        this.nombre = Objects.requireNonNull(nombre);
        if(this.nombre.isBlank()){
            throw new IllegalArgumentException("Se debe ingresar un nombre que no sea vacío");
        }
        this.nombreId = Objects.requireNonNull(entityId);
        this.cuentaId = Objects.requireNonNull(cuentaId);
    }

    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if(this.nombre.isBlank()){
            throw new IllegalArgumentException("Se debe ingresar un nombre que no sea vacío");
        }
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
