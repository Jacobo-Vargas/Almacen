package model;

import java.time.LocalDate;

public class ProductoEnvasado extends Producto{

    private final LocalDate fechaEnvasado;
    private final float pesoProducto;
    private final PaisOrigen paisProducto;

    public ProductoEnvasado(String codigoProducto, String nombreProducto, String descripcionProducto, float valorUnitario, int cantidadExistente, LocalDate fechaEnvasado, float pesoProducto, PaisOrigen paisProducto) {
        super(codigoProducto, nombreProducto, descripcionProducto, valorUnitario, cantidadExistente);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoProducto = pesoProducto;
        this.paisProducto = paisProducto;
    }

    public LocalDate getFechaEnvasado() {
        return fechaEnvasado;
    }

    public float getPesoProducto() {
        return pesoProducto;
    }

    public PaisOrigen getPaisProducto() {
        return paisProducto;
    }
}
