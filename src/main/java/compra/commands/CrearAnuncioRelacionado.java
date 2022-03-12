package compra.commands;

import co.com.sofka.domain.generic.Command;
import compra.values.Cookies;
import compra.values.Publicidad;

public class CrearAnuncioRelacionado extends Command {

    private final Publicidad publicidad;
    private final Cookies cookies;

    public CrearAnuncioRelacionado(Publicidad publicidad, Cookies cookies) {
        this.publicidad = publicidad;
        this.cookies = cookies;
    }

    public Publicidad getPublicidad() {
        return this.publicidad;
    }

    public Cookies getCookies() {
        return this.cookies;
    }
}
