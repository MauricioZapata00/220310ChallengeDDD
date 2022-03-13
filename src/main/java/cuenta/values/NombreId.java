package cuenta.values;

import co.com.sofka.domain.generic.Identity;

public class NombreId extends Identity {

    public NombreId(){

    }

    private NombreId(Long id){
        super(id.toString());
    }

    public static NombreId of(Long id){
        return new NombreId(id);
    }
}
