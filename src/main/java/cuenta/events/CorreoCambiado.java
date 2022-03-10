package cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import cuenta.Email;

public class CorreoCambiado extends DomainEvent {

    private Email email;
    public CorreoCambiado(Email email) {
        super("cliente.cuenta.correoCambiado");
        this.email = email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
