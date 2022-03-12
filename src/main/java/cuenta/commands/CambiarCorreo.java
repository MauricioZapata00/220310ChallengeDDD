package cuenta.commands;

import co.com.sofka.domain.generic.Command;
import cuenta.values.EmailId;

public class CambiarCorreo extends Command {

    private final EmailId emailId;
    private final String email;

    public CambiarCorreo(EmailId emailId, String email) {
        this.emailId = emailId;
        this.email = email;
    }

    public EmailId getEmailId() {
        return this.emailId;
    }

    public String getEmail() {
        return this.email;
    }
}
