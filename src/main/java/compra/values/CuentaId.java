package compra.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaId extends Identity {

    public CuentaId(){

    }

    private CuentaId(Long id){
        super(id.toString());
    }

    public static CuentaId of(Long id){
        return new CuentaId(id);
    }
}
