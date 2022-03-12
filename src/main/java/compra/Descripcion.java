package compra;

import co.com.sofka.domain.generic.Entity;
import compra.values.DescripcionId;

public class Descripcion extends Entity<DescripcionId> {

    private String informacion;

    public Descripcion(DescripcionId entityId, String informacion) {
        super(entityId);
        this.informacion = informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
