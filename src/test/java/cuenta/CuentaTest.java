package cuenta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import cuenta.commands.CambiarNombre;
import cuenta.commands.CrearCuenta;
import cuenta.events.CuentaCreada;
import cuenta.events.NombreCambiado;
import cuenta.values.CuentaId;
import cuenta.values.DireccionId;
import cuenta.values.EmailId;
import cuenta.values.NombreId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import usecases.CambiarNombreCuentaUseCase;
import usecases.CrearCuentaUseCase;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@ExtendWith(MockitoExtension.class)
public class CuentaTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void crearCuenta(){
        //Arrange

        Random aleatorio = new SecureRandom();//Just to generate random values
        CuentaId cuentaId = CuentaId.of(aleatorio.nextLong());
        NombreId nombreId = NombreId.of(aleatorio.nextLong());
        DireccionId direccionId = DireccionId.of(aleatorio.nextLong());
        EmailId emailId = EmailId.of(aleatorio.nextLong());
        Nombre nombre = new Nombre(cuentaId, nombreId, "Pepito");
        Direccion direccion = new Direccion(direccionId, "Calle 10 # 18 - 20");
        Email email = new Email(emailId, "pepito@gmail.com");
        CrearCuenta crearCuenta = new CrearCuenta(cuentaId, nombre, direccion, email);
        CrearCuentaUseCase crearCuentaUseCase = new CrearCuentaUseCase();

        //Act

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


    @Test
    public void cambiarNombre(){
        //Arrange

        Random aleatorio = new SecureRandom();//Just to generate random values
        //Long long1 = new Long(147896523);
        Long long1 = Long.valueOf(147896523);
        Long long2 = Long.valueOf(147852369);
        CuentaId cuentaId = CuentaId.of(long1);
        NombreId nombreId = NombreId.of(long2);
        String nombreACambiar = "Jaimito";

        CambiarNombre cambiarNombre = new CambiarNombre(cuentaId, nombreId, nombreACambiar);
        CambiarNombreCuentaUseCase cambiarNombreCuentaUseCase = new CambiarNombreCuentaUseCase();
        System.out.println(cuentaId.value());
        Mockito.when(repository.getEventsBy(cuentaId.toString())).thenReturn(history());
        cambiarNombreCuentaUseCase.addRepository(repository);

        //Act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(cuentaId.value())
                .syncExecutor(cambiarNombreCuentaUseCase, new RequestCommand<>(cambiarNombre))
                .orElseThrow()
                .getDomainEvents();

        //Assert

        var event = (NombreCambiado)events.get(0);
        Assert.assertEquals("cliente.cuenta.nombrecambiado", event.type);
        Assert.assertEquals(cambiarNombre.getNombre(), event.getNombre().getNombre());
    }



    private List<DomainEvent> history() {
        Random aleatorio = new SecureRandom();//Just to generate random values
        Long long1 = Long.valueOf(147896523);
        Long long2 = Long.valueOf(147852369);
        //CuentaId cuentaId = CuentaId.of(aleatorio.nextLong());
        CuentaId cuentaId = CuentaId.of(long1);
        //NombreId nombreId = NombreId.of(aleatorio.nextLong());
        NombreId nombreId = NombreId.of(long2);
        DireccionId direccionId = DireccionId.of(aleatorio.nextLong());
        EmailId emailId = EmailId.of(aleatorio.nextLong());
        Nombre nombre = new Nombre(cuentaId, nombreId, "Pepito");
        Direccion direccion = new Direccion(direccionId, "Calle 10 # 18 - 20");
        Email email = new Email(emailId, "pepito@gmail.com");
        return List.of(new CuentaCreada(cuentaId, nombre, direccion, email));
    }
}
