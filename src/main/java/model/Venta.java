package model;

import java.time.LocalDate;
import java.util.List;

public class Venta {
    private final String codigo;
    private final LocalDate fechaVenta;
    private static List<DetalleVenta> detalleVenta;
    private final Cliente cliente;
    private float total;
    private float iva;

    public Venta(String codigo, LocalDate fechaVenta, List<DetalleVenta> detalleVenta, Cliente cliente, float total, float iva) {
        this.codigo = codigo;
        this.fechaVenta = fechaVenta;
        Venta.detalleVenta = detalleVenta;
        this.cliente = cliente;
        this.total = total;
        this.iva = iva;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public List<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
        Venta.detalleVenta = detalleVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }
}
