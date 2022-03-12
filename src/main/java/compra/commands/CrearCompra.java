package compra.commands;

import co.com.sofka.domain.generic.Command;
import compra.AnuncioRelacionado;
import compra.values.CompraId;

public class CrearCompra extends Command {

    private final CompraId compraId;
    private final AnuncioRelacionado anuncioRelacionado;

    public CrearCompra(CompraId compraId, AnuncioRelacionado anuncioRelacionado) {
        this.compraId = compraId;
        this.anuncioRelacionado = anuncioRelacionado;
    }

    public CompraId getCompraId() {
        return this.compraId;
    }

    public AnuncioRelacionado getAnuncioRelacionado() {
        return this.anuncioRelacionado;
    }
}
