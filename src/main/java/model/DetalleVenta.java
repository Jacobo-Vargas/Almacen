package model;

public class DetalleVenta {
    private int cantidadProductos;
    private float subtotal;
    private Producto productoVendido;

    public DetalleVenta(int cantidadProductos, float subtotal, Producto productoVendido) {
        this.cantidadProductos = cantidadProductos;
        this.subtotal = subtotal;
        this.productoVendido = productoVendido;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProductoVendido() {
        return productoVendido;
    }

    public void setProductoVendido(Producto productoVendido) {
        this.productoVendido = productoVendido;
    }
}
