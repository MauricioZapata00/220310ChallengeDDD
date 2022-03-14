package registroCompra;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.Assert;
import org.junit.Test;
import registroCompra.commands.CrearRegistroCompra;
import registroCompra.events.RegistroAgregado;
import registroCompra.values.RegistroCompraId;
import usecases.CrearRegistroCompraUseCase;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class RegistroCompraTest {

    @Test
    public void crearRegistroCompra(){

        //Arrange

        Random aleatorio = new SecureRandom();//Just to generate random values
        RegistroCompraId registroCompraId = RegistroCompraId.of(aleatorio.nextLong());
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Orden> ordenes = new ArrayList<>();
        CrearRegistroCompra crearRegistroCompra = new CrearRegistroCompra(registroCompraId,
                productos, ordenes);
        CrearRegistroCompraUseCase crearRegistroCompraUseCase = new CrearRegistroCompraUseCase();

        //Act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(crearRegistroCompraUseCase, new RequestCommand<>(crearRegistroCompra))
                .orElseThrow()
                .getDomainEvents();

        //Assert

        var event = (RegistroAgregado)events.get(0);
        Assert.assertEquals("baseDeDatos.registroCompras.registroAgregado", event.type);
        Assert.assertEquals(registroCompraId.toString(), event.aggregateRootId());
        Assert.assertEquals(productos, event.getProductos());
        Assert.assertEquals(ordenes, event.getOrdenes());
    }
}
