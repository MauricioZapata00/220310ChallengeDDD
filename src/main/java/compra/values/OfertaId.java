package compra.values;

import co.com.sofka.domain.generic.Identity;

public class OfertaId extends Identity {

    public OfertaId(){

    }

    private OfertaId(Long id){
        super(id.toString());
    }

    public static OfertaId of(Long id){
        return new OfertaId(id);
    }
}
