package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import compra.AnuncioRelacionado;
import compra.commands.CrearAnuncioRelacionado;
import compra.values.AnuncioId;

import java.util.List;

public class CrearAnuncioRelacionadoUseCase extends UseCase<RequestCommand<CrearAnuncioRelacionado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAnuncioRelacionado> crearAnuncioRelacionadoRequestCommand) {
        CrearAnuncioRelacionado crearAnuncioRelacionado = crearAnuncioRelacionadoRequestCommand.getCommand();
        AnuncioRelacionado anuncioRelacionado = new AnuncioRelacionado(crearAnuncioRelacionado.getAnuncioId(),
                crearAnuncioRelacionado.getPublicidad(), crearAnuncioRelacionado.getCookies());
        emit().onResponse(new ResponseEvents((List<DomainEvent>) anuncioRelacionado));
    }
}
