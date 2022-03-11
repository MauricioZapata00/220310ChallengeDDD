package cuenta.values;

import co.com.sofka.domain.generic.Identity;

public class DireccionId extends Identity {

    public DireccionId(){

    }

    private DireccionId(Long id){
        super(id.toString());
    }

    public static DireccionId of(Long id){
        return new DireccionId(id);
    }
}
