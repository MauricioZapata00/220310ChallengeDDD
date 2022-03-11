package registroCompra.values;

import co.com.sofka.domain.generic.Identity;

public class ProductoId extends Identity {

    public ProductoId(){

    }

    private ProductoId(Long id){
        super(id.toString());
    }

    public static ProductoId of(Long id){
        return new ProductoId(id);
    }
}
