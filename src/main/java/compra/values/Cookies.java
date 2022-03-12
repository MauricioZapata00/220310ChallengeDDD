package compra.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cookies implements ValueObject<Boolean> {

    private Boolean aceptado;

    public Cookies(Boolean aceptado){
        this.aceptado = Objects.requireNonNull(aceptado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cookies)) return false;
        Cookies cookies = (Cookies) o;
        return Objects.equals(aceptado, cookies.aceptado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aceptado);
    }

    @Override
    public Boolean value() {
        return this.aceptado;
    }
}
