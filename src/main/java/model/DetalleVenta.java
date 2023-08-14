package model;

public class DetalleVenta {
    private int cantidadProductos;
    private float subtotal;
    private Producto productoVendido;

    public DetalleVenta(int cantidadProductos,Producto productoVendido) {
        this.cantidadProductos = cantidadProductos;
        this.productoVendido = productoVendido;
    }

    public boolean consultarDisponibilidad() {

        return AlmacenInstance.INSTANCE.getAlmacen()
                .getListProductos()
                .stream()
                .filter(producto -> producto.getCodigoProducto().equals(productoVendido.getCodigoProducto()))
                .anyMatch(producto -> producto.getCantidadExistente() >= cantidadProductos);

    }

    public void descontarProductos(){
        for (Producto p: AlmacenInstance.INSTANCE.getAlmacen().getListProductos()) {
            if(p.getCodigoProducto().equals(productoVendido.getCodigoProducto())){
                p.setCantidadExistente(p.getCantidadExistente()-cantidadProductos);
            }
        }
    }
    public float subtotalPagar(){
        if(consultarDisponibilidad()){
            descontarProductos();
            subtotal = productoVendido.getValorUnitario()*cantidadProductos;
        }else{
            subtotal = 0;
        }
        return subtotal;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public float getSubtotal() {
        return subtotalPagar();
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

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "cantidadProductos=" + cantidadProductos +
                ", subtotal=" + subtotal +
                ", productoVendido=" + productoVendido +
                '\n'+'}' ;
    }
}
