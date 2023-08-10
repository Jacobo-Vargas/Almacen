package model;

import java.util.List;

public class Almacen {
    private static List<Venta> listVentas;
    private static List<Producto> listProductos;
    private static List<Cliente> listClientes;

    public Almacen() {
    }
    public void registrarProducto(Producto producto){
        listProductos.add(producto);
    }
    public void registrarCliente(Cliente cliente){
        listClientes.add(cliente);
    }
    public void venderProducto(Venta venta){
        listVentas.add(venta);
    }
    public void descontarProductoVendido(){

    }

    public static List<Venta> getListVentas() {
        return listVentas;
    }

    public static void setListVentas(List<Venta> listVentas) {
        Almacen.listVentas = listVentas;
    }

    public static List<Producto> getListProductos() {
        return listProductos;
    }

    public static void setListProductos(List<Producto> listProductos) {
        Almacen.listProductos = listProductos;
    }

    public static List<Cliente> getListCliente() {
        return listClientes;
    }

    public static void setListCliente(List<Cliente> listCliente) {
        Almacen.listClientes = listCliente;
    }
}
