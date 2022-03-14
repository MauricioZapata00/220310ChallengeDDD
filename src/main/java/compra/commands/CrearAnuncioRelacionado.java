package compra.commands;

import co.com.sofka.domain.generic.Command;
import compra.values.AnuncioId;
import compra.values.Cookies;
import compra.values.Publicidad;

public class CrearAnuncioRelacionado extends Command {

    private final Publicidad publicidad;
    private final Cookies cookies;
    private final AnuncioId anuncioId;

    public CrearAnuncioRelacionado(AnuncioId anuncioId, Publicidad publicidad, Cookies cookies) {
        this.publicidad = publicidad;
        this.cookies = cookies;
        this.anuncioId = anuncioId;
    }

    public Publicidad getPublicidad() {
        return this.publicidad;
    }

    public Cookies getCookies() {
        return this.cookies;
    }

    public AnuncioId getAnuncioId() {
        return this.anuncioId;
    }
}
