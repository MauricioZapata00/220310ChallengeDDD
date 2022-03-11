package pago.values;

import co.com.sofka.domain.generic.Identity;

public class PagoId extends Identity {

    public PagoId(){

    }

    private PagoId(Long id){
        super(id.toString());
    }

    public static PagoId of(Long id){
        return new PagoId(id);
    }
}
