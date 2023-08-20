package model;

import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private static int ultimoCodigo = 0;
    private final int codigoVenta;
    private final LocalDate fechaVenta;
    private List<DetalleVenta> detalleVenta = new ArrayList<>();
    private final Cliente cliente;
    private float total;
    private float iva;

    public Venta( Cliente cliente, float iva) {

        this.codigoVenta = ++ultimoCodigo; // Incrementa el contador y asigna el código
        this.fechaVenta = LocalDate.now();
        this.cliente = cliente;
        this.iva = iva;
        this.total = calcularTotal();
    }

    public float calcularTotal() {
        float valorSinIva = (float) detalleVenta.stream().mapToDouble(DetalleVenta::getSubtotal).sum();
        total = (valorSinIva+(valorSinIva*(iva/100)));
        return (valorSinIva+(valorSinIva*(iva/100)));
    }


    public int getCodigo() {
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
