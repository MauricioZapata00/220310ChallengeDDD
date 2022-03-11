package compra.values;

import co.com.sofka.domain.generic.Identity;

public class DescripcionId extends Identity {

    public DescripcionId(){

    }

    private DescripcionId(Long id){
        super(id.toString());
    }

    public static DescripcionId of(Long id){
        return new DescripcionId(id);
    }
}
