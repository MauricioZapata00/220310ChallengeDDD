package cuenta.values;

import co.com.sofka.domain.generic.Identity;

public class EmailId extends Identity {

    public EmailId(){

    }

    private EmailId(Long id){
        super(id.toString());
    }

    public static EmailId of(Long id){
        return new EmailId(id);
    }
}
