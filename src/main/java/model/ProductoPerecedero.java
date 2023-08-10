package model;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto{

    private final LocalDate fechaVencimiento;

    public ProductoPerecedero(String codigoProducto, String nombreProducto, String descripcionProducto, float valorUnitario, int cantidadExistente, LocalDate fechaVencimiento) {
        super(codigoProducto, nombreProducto, descripcionProducto, valorUnitario, cantidadExistente);
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
}
