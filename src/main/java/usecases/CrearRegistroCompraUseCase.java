package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import registroCompra.RegistroCompra;
import registroCompra.commands.CrearRegistroCompra;

public class CrearRegistroCompraUseCase extends UseCase<RequestCommand<CrearRegistroCompra>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRegistroCompra> crearRegistroCompraRequestCommand) {
        CrearRegistroCompra crearRegistroCompra = crearRegistroCompraRequestCommand.getCommand();
        RegistroCompra registroCompra = new RegistroCompra(crearRegistroCompra.getRegistroCompraId(),
                crearRegistroCompra.getProductos(), crearRegistroCompra.getOrdenes());
        emit().onResponse(new ResponseEvents(registroCompra.getUncommittedChanges()));
    }
}
