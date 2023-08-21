package model;


public class DetalleVenta {
    private int cantidadProductos;
    private float subtotal;
    private String productoVendido;

    public DetalleVenta(int cantidadProductos,String productoVendido) {
        this.cantidadProductos = cantidadProductos;
        this.productoVendido = productoVendido;
        this.subtotal = subtotalPagar();
    }

    public boolean consultarDisponibilidad() {
        return AlmacenInstance.INSTANCE.getAlmacen()
                .getListProductos()
                .stream()
                .filter(producto -> producto.getCodigoProducto().equals(productoVendido))
                .anyMatch(producto -> producto.getCantidadExistente() >= cantidadProductos);

    }

    public float subtotalPagar(){
        if(consultarDisponibilidad()){
            subtotal = obtenerPrecioProducto()*cantidadProductos;
        }else{
            subtotal = 0;
        }
        return subtotal;
    }

    public float obtenerPrecioProducto(){
        float valor = 0;
        for (Producto p: AlmacenInstance.INSTANCE.getAlmacen().getListProductos()) {
            if(p.getCodigoProducto().equals(productoVendido)){
                valor = p.getValorUnitario();
            }
        }
        return valor;
    }

    public String obtenerNombreProducto(){
        String nombre  = "";
        for (Producto p: AlmacenInstance.INSTANCE.getAlmacen().getListProductos()) {
            if(p.getCodigoProducto().equals(productoVendido)){
                nombre = p.getNombreProducto();
            }
        }
        return nombre;
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

    public String getProductoVendido() {
        return productoVendido;
    }

    public void setProductoVendido(String productoVendido) {
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
