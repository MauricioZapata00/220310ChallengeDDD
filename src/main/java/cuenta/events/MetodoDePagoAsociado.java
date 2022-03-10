package cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import cuenta.values.MetodoDePago;

public class MetodoDePagoAsociado extends DomainEvent {

    private MetodoDePago metodoDePago;
    public MetodoDePagoAsociado(MetodoDePago metodoDePago) {
        super("cliente.cuenta.metodoDePagoAsociado");
        this.metodoDePago = metodoDePago;
    }

    public void setMetodoDePago(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
}
