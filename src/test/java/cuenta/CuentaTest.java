package cuenta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import cuenta.commands.CrearCuenta;
import cuenta.events.CuentaCreada;
import cuenta.values.CuentaId;
import cuenta.values.DireccionId;
import cuenta.values.EmailId;
import cuenta.values.NombreId;
import org.junit.Assert;
import org.junit.Test;
import usecases.CrearCuentaUseCase;

import java.security.SecureRandom;
import java.util.Random;

public class CuentaTest {

    @Test
    public void crearCuenta(){
        //Arrange

        Random aleatorio = new SecureRandom();//Just to generate random values
        CuentaId cuentaId = CuentaId.of(aleatorio.nextLong());
        NombreId nombreId = NombreId.of(aleatorio.nextLong());
        DireccionId direccionId = DireccionId.of(aleatorio.nextLong());
        EmailId emailId = EmailId.of(aleatorio.nextLong());
        Nombre nombre = new Nombre(nombreId, "Pepito");
        Direccion direccion = new Direccion(direccionId, "Calle 10 # 18 - 20");
        Email email = new Email(emailId, "pepito@gmail.com");
        CrearCuenta crearCuenta = new CrearCuenta(cuentaId, nombre, direccion, email);

        //Act

        CrearCuentaUseCase crearCuentaUseCase = new CrearCuentaUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(crearCuentaUseCase, new RequestCommand<>(crearCuenta))
                .orElseThrow()
                .getDomainEvents();

        //Assert

        var event = (CuentaCreada)events.get(0);
        Assert.assertEquals("cliente.cuenta.cuentaCreada", event.type);
        Assert.assertEquals(cuentaId.toString(), event.aggregateRootId());
        Assert.assertEquals(nombre, event.getNombre());
        Assert.assertEquals(direccion, event.getDireccion());
        Assert.assertEquals(email, event.getEmail());
    }
}
