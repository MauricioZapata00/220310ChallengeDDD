package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import cuenta.Cuenta;
import cuenta.commands.CrearCuenta;

public class CrearCuentaUseCase extends UseCase<RequestCommand<CrearCuenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCuenta> crearCuentaRequestCommand) {
        CrearCuenta crearCuenta = crearCuentaRequestCommand.getCommand();
        Cuenta cuenta = new Cuenta(crearCuenta.getCuentaId(), crearCuenta.getNombre(),
                crearCuenta.getDireccion(), crearCuenta.getEmail());
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
