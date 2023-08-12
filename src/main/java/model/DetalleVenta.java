package model;

public class DetalleVenta {
    private int cantidadProductos;
    private float subtotal;
    private Producto productoVendido;

    public DetalleVenta(int cantidadProductos,Producto productoVendido) {
        this.cantidadProductos = cantidadProductos;
        this.subtotal = subtotal();
        this.productoVendido = productoVendido;
    }

    public boolean consultarDisponibilidad(){
        if((productoVendido.getCantidadExistente()) >= cantidadProductos){
            return true;
        }else{
            return false;
        }
    }
    public float subtotal(){
        if(consultarDisponibilidad()){
            return productoVendido.getValorUnitario()*cantidadProductos;
        }else{
            return 0;
        }
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
