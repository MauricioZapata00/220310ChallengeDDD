package compra.commands;

import co.com.sofka.domain.generic.Command;
import compra.values.AnuncioId;
import compra.values.Cookies;
import compra.values.Publicidad;

public class CambiarAnuncio extends Command {

    private final AnuncioId anuncioId;
    private final Publicidad publicidad;
    private final Cookies cookies;

    public CambiarAnuncio(AnuncioId anuncioId, Publicidad publicidad, Cookies cookies) {
        this.anuncioId = anuncioId;
        this.publicidad = publicidad;
        this.cookies = cookies;
    }

    public AnuncioId getAnuncioId() {
        return this.anuncioId;
    }

    public Publicidad getPublicidad() {
        return this.publicidad;
    }

    public Cookies getCookies() {
        return this.cookies;
    }
}
