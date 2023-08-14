package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Venta {
    private final String codigoVenta;
    private final LocalDate fechaVenta;
    private List<DetalleVenta> detalleVenta = new ArrayList<>();
    private final Cliente cliente;
    private float total;
    private float iva;

    public Venta(String codigoVenta, LocalDate fechaVenta,Cliente cliente, float iva) {
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.cliente = cliente;
        this.iva = iva;
    }

    public float calcularTotal() {
        total = (float) detalleVenta.stream().mapToDouble(DetalleVenta::getSubtotal).sum();
        return ((total*(iva/100))+total);
    }


    public String getCodigo() {
        return codigoVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public List<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
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

    @Override
    public String toString() {
        return "Venta{" +
                "codigoVenta='" + codigoVenta + '\'' +
                ", fechaVenta=" + fechaVenta +
                ", detalleVenta=" + detalleVenta +
                ", cliente=" + cliente +
                ", total=" + total +
                ", iva=" + iva +
                '}';
    }
}
