package compra;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Entity;
import compra.values.AnuncioId;
import compra.values.Cookies;
import compra.values.Publicidad;

import java.util.List;

public class AnuncioRelacionado extends Entity<AnuncioId> {

    private Publicidad publicidad;
    private Cookies cookies;
    public AnuncioRelacionado(AnuncioId entityId, Publicidad publicidad, Cookies cookies) {
        super(entityId);
        this.publicidad = publicidad;
        this.cookies = cookies;
    }

    public Publicidad getPublicidad() {
        return publicidad;
    }

    public Cookies getCookies() {
        return cookies;
    }
}
