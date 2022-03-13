package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import pago.commands.VerFactura;


public class VerFacturaUseCase extends UseCase<RequestCommand<VerFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<VerFactura> verFacturaRequestCommand) {
        VerFactura verFactura = verFacturaRequestCommand.getCommand();

    }
}
