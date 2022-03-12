package cuenta;

import co.com.sofka.domain.generic.Entity;
import cuenta.values.EmailId;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email extends Entity<EmailId> {

    private String email;

    public Email(EmailId entityId, String email) {
        super(entityId);
        Objects.requireNonNull(email);
        if(this.email.isBlank()){
            throw new IllegalArgumentException("Ingresa un correo que no sea vacío");
        }
        //Check if the email is valid
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
        if(!(mat.matches())){
            throw new IllegalArgumentException("Ingresa un correo válido");
        }
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email);
        if(this.email.isBlank()){
            throw new IllegalArgumentException("Ingresa un correo que no sea vacío");
        }
        //Check if the email is valid
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
        if(!(mat.matches())){
            throw new IllegalArgumentException("Ingresa un correo válido");
        }
        this.email = email;
    }
}
