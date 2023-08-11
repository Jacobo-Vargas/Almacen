package model;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private static   List<Venta> listVentas;
    private static List<Producto> listProductos;
    private static List<Cliente> listClientes;
    private static List<DetalleVenta> listDetalleVenta;


    public Almacen() {
        listVentas=new ArrayList<>();
        listProductos=new ArrayList<>();
        listClientes=new ArrayList<>();
        listDetalleVenta=new ArrayList<>();
    }

    public void eliminarCliente(String numeroIdentificacion){
        for (int i=0 ; i<listClientes.size() ; i++){
            if(listClientes.get(i).getNumeroIdentificacion().equals(numeroIdentificacion)){
                listClientes.remove(listClientes.get(i));
            }
        }
    }
    public void eliminarProducto(Producto codigo){
        for (int i=0 ; i<listProductos.size() ; i++){
            if(listProductos.get(i).getCodigoProducto().equals(codigo)){
                listProductos.remove(listProductos.get(i));
            }
        }
    }
    public void eliminarVenta(Venta codigo){
        for (int i=0 ; i<listVentas.size() ; i++){
            if(listVentas.get(i).getCodigo().equals(codigo)){
                listVentas.remove(listVentas.get(i));
            }
        }
    }
    public void eliminarDetalleVenta(){
        //pendiente
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
    public void registrarDetalleVenta(DetalleVenta detalleVenta){
        listDetalleVenta.add(detalleVenta);
    }

    public void descontarProductoVendido(){

    }

    public List<Venta> getListVentas() {
        return listVentas;
    }

    public void setListVentas(List<Venta> listVentas) {
        this.listVentas = listVentas;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public List<DetalleVenta> getListDetalleVenta() {
        return listDetalleVenta;
    }

    public void setListDetalleVenta(List<DetalleVenta> listDetalleVenta) {
        this.listDetalleVenta = listDetalleVenta;
    }
}
