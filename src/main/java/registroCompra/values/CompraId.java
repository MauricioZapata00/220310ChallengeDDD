package registroCompra.values;

import co.com.sofka.domain.generic.Identity;

public class CompraId extends Identity {

    public CompraId(){

    }

    private CompraId(Long id){
        super(id.toString());
    }

    public static CompraId of(Long id){
        return new CompraId(id);
    }
}
