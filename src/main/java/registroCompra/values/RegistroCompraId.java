package registroCompra.values;

import co.com.sofka.domain.generic.Identity;

public class RegistroCompraId extends Identity {

    public RegistroCompraId(){

    }

    private RegistroCompraId(Long id){
        super(id.toString());
    }

    public static RegistroCompraId of(Long id){
        return new RegistroCompraId(id);
    }
}
