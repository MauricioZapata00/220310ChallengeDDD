package pago;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.Assert;
import org.junit.Test;
import pago.commands.CrearPago;
import pago.events.TransferenciaRealizada;
import pago.values.Factura;
import pago.values.PagoId;
import pago.values.Transferencia;
import usecases.CrearPagoUseCase;

import java.security.SecureRandom;
import java.util.Random;

public class PagoTest {

    @Test
    public void crearPago(){
        //Arrange

        Random aleatorio = new SecureRandom();//Just to generate random values
        PagoId pagoId = PagoId.of(aleatorio.nextLong());
        //This is just to set a random value for factura
        final Double MINIMUM = 499999.99;
        final Double MAXIMUM = 1000000.00;
        Double randomDouble = MINIMUM + ((MAXIMUM - MINIMUM) * aleatorio.nextDouble());
        Factura factura = new Factura(randomDouble);
        String cuentaOrigen = "147852369";
        String cuentaDestino = "963852741";
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, randomDouble);
        CrearPago crearPago = new CrearPago(pagoId, factura, transferencia);

        //Act

        CrearPagoUseCase crearPagoUseCase = new CrearPagoUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(crearPagoUseCase, new RequestCommand<>(crearPago))
                .orElseThrow()
                .getDomainEvents();
        //Assert

        var event = (TransferenciaRealizada)events.get(0);
        Assert.assertEquals("banco.pago.transferenciaRealizada", event.type);
        Assert.assertEquals(pagoId.toString(), event.aggregateRootId());
        Assert.assertEquals(factura, event.getFactura());
        Assert.assertEquals(transferencia, event.getTransferencia());
    }

    @Test
    public void verFactura(){

    }
}
