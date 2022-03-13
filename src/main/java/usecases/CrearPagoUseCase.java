package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import pago.Pago;
import pago.commands.CrearPago;

public class CrearPagoUseCase extends UseCase<RequestCommand<CrearPago>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPago> crearPagoRequestCommand) {
        CrearPago crearPago = crearPagoRequestCommand.getCommand();
        Pago pago = new Pago(crearPago.getPagoId(), crearPago.getFactura(),
                crearPago.getTransferencia());
        emit().onResponse(new ResponseEvents(pago.getUncommittedChanges()));
    }
}
