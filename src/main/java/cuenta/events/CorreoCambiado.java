package cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import cuenta.Email;
import cuenta.values.EmailId;

public class CorreoCambiado extends DomainEvent {

    private Email email;
    public CorreoCambiado(EmailId emailId, String email) {
        super("cliente.cuenta.correoCambiado");
        this.email = new Email(emailId, email);
    }

    public Email getEmail() {
        return this.email;
    }
}
