package registroCompra.values;

import co.com.sofka.domain.generic.Identity;

public class CostoInventarioId extends Identity {

    public CostoInventarioId(){

    }

    private CostoInventarioId(Long id){
        super(id.toString());
    }

    public static CostoInventarioId of(Long id){
        return new CostoInventarioId(id);
    }
}
