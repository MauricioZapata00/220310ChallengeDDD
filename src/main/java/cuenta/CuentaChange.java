package cuenta;

import co.com.sofka.domain.generic.EventChange;
import cuenta.events.*;

import java.util.ArrayList;

public class CuentaChange extends EventChange {
    public CuentaChange(Cuenta cuenta) {
        apply((CuentaCreada event) -> {
            cuenta.nombre = event.getNombre();
            cuenta.direccion = event.getDireccion();
            cuenta.email = event.getEmail();
            cuenta.pagoIds = new ArrayList<>();
            cuenta.compraIds = new ArrayList<>();
        });
        apply((NombreCambiado event) -> {
            cuenta.nombre = event.getNombre();
        });
        apply((DireccionCambiada event) -> {
            cuenta.direccion = event.getDireccion();
        });
        apply((CorreoCambiado event) -> {
            cuenta.email = event.getEmail();
        });
        apply((MetodoDePagoAsociado event) -> {
            event.setMetodoDePago(cuenta.metodoDePago);
        });
    }
}
