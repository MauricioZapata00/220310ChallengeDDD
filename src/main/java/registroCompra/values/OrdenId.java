package registroCompra.values;

import co.com.sofka.domain.generic.Identity;

public class OrdenId extends Identity {

    public OrdenId(){

    }

    private OrdenId(Long id){
        super(id.toString());
    }

    public static OrdenId of(Long id){
        return new OrdenId(id);
    }
}
