package compra.values;

import co.com.sofka.domain.generic.Identity;

public class AnuncioId extends Identity {

    public AnuncioId(){

    }

    private AnuncioId(Long id){
        super(id.toString());
    }

    public static AnuncioId of(Long id){
        return new AnuncioId(id);
    }
}
