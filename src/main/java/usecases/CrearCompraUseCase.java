package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import compra.Compra;
import compra.commands.CrearCompra;

public class CrearCompraUseCase extends UseCase<RequestCommand<CrearCompra>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCompra> crearCompraRequestCommand) {
        CrearCompra crearCompra = crearCompraRequestCommand.getCommand();
        Compra compra = new Compra(crearCompra.getCompraId(), crearCompra.getAnuncioRelacionado());
        emit().onResponse(new ResponseEvents(compra.getUncommittedChanges()));
    }
}
