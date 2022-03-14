package compra;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import compra.commands.CrearAnuncioRelacionado;
import compra.commands.CrearCompra;
import compra.events.AnuncioCambiado;
import compra.events.CompraHecha;
import compra.values.AnuncioId;
import compra.values.CompraId;
import compra.values.Cookies;
import compra.values.Publicidad;
import org.junit.Assert;
import org.junit.Test;
import usecases.CrearAnuncioRelacionadoUseCase;
import usecases.CrearCompraUseCase;

import java.security.SecureRandom;
import java.util.Random;

public class CompraTest {

    @Test
    public void crearCompra(){
        //Arrange

        Random aleatorio = new SecureRandom();//Just to generate random values
        CompraId compraId = CompraId.of(aleatorio.nextLong());
        AnuncioId anuncioId = AnuncioId.of(aleatorio.nextLong());
        Cookies cookies = new Cookies(true);
        Publicidad publicidad = new Publicidad("www.google.com/images?=algo",
                "Esto es algo que se obtiene de Google");
        AnuncioRelacionado anuncioRelacionado = new AnuncioRelacionado(anuncioId, publicidad, cookies);
        CrearCompra crearCompra = new CrearCompra(compraId, anuncioRelacionado);
        CrearCompraUseCase crearCompraUseCase = new CrearCompraUseCase();

        //Act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(crearCompraUseCase, new RequestCommand<>(crearCompra))
                .orElseThrow()
                .getDomainEvents();

        //Assert

        var event = (CompraHecha)events.get(0);
        Assert.assertEquals("aplicacion.compra.compraHecha", event.type);
        Assert.assertEquals(compraId.toString(), event.aggregateRootId());
        Assert.assertEquals(anuncioRelacionado, event.getAnuncioRelacionado());
    }

    /*
    @Test
    public void crearAnuncioRelacionado(){
        //Arrange

        Random aleatorio = new SecureRandom();//Just to generate random values
        AnuncioId anuncioId = AnuncioId.of(aleatorio.nextLong());
        Cookies cookies = new Cookies(false);
        Publicidad publicidad = new Publicidad("www.google.com/images?=cosas",
                "Esto son cosas que se obtienen de google");
        CrearAnuncioRelacionado crearAnuncioRelacionado = new CrearAnuncioRelacionado(anuncioId,
                publicidad, cookies);
        CrearAnuncioRelacionadoUseCase crearAnuncioRelacionadoUseCase = new CrearAnuncioRelacionadoUseCase();

        //Act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(crearAnuncioRelacionadoUseCase,
                        new RequestCommand<>(crearAnuncioRelacionado))
                .orElseThrow()
                .getDomainEvents();
        //Assert

        var event = (AnuncioCambiado)events.get(0);
        Assert.assertEquals("aplicacion.compra.anuncioCambiado", event.type);
        Assert.assertEquals(anuncioId.toString(), event.aggregateRootId());
        Assert.assertEquals(cookies, event.getAnuncioRelacionado().getCookies());
        Assert.assertEquals(publicidad, event.getAnuncioRelacionado().getPublicidad());
    }

     */
}
