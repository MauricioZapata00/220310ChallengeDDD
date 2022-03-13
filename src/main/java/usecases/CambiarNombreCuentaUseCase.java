package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import cuenta.Cuenta;
import cuenta.Nombre;
import cuenta.commands.CambiarNombre;
import cuenta.commands.CrearCuenta;

public class CambiarNombreCuentaUseCase extends UseCase<RequestCommand<CambiarNombre>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarNombre> cambiarNombreRequestCommand) {
        CambiarNombre cambiarNombre = cambiarNombreRequestCommand.getCommand();
        Cuenta cuenta = Cuenta.from(cambiarNombre.getCuentaId(), retrieveEvents());
        cuenta.cambiarNombre(cambiarNombre.getCuentaId(), cambiarNombre.getNombreId(),
                cambiarNombre.getNombre());
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
