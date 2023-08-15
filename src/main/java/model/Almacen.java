package model;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private List<Venta> listVentas = new ArrayList<>();
    private List<Producto> listProductos = new ArrayList<>();
    private List<Cliente> listClientes = new ArrayList<>();

    public Almacen() {
    }

    public void registrarProducto(Producto producto) {
        try {
            if (getListProductos().stream().anyMatch(producto1 -> producto1.getCodigoProducto().equals(producto.getCodigoProducto()))) {
                System.out.println("El codigo ya existe");
            } else {
                System.out.println("Se agrego");
                listProductos.add(producto);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    public void eliminarClienteIdentificacion(String numeroIdentificacion){
        boolean respuesta=false;
        try{
            for (int i=0;i<listClientes.size();i++){
                if (listClientes.get(i).getNumeroIdentificacion().equals(numeroIdentificacion)){
                    respuesta=true;
                    listClientes.remove(listClientes.get(i));
                }
            }
            if(respuesta==false){
                System.out.println("Cliente no encontrad0");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void eliminarProductoCodigo(String codigo){
        boolean respuesta=false;
        try {
            for(int i=0;i<listProductos.size();i++){
                if(listProductos.get(i).getCodigoProducto().equals(codigo)){
                    listProductos.remove(listVentas.get(i));
                    respuesta=true;
                }
            }
            if(respuesta==false){
                System.out.println("producto no encontrado");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void eliminarVenta(String codigo){
        boolean respuesta=false;
        try{
            for(int i=0; i<listVentas.size();i++){
                if(listVentas.get(i).getCodigo().equals(codigo)){
                    listVentas.remove(listVentas.get(i));
                    System.out.println("venta elimida");
                    respuesta=true;
                }
            }
            if(respuesta==false){
                System.out.println("venta no encontrada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Venta buscarVentaCodigo(String codigoVenta){
        boolean respuesta=false;
        try {
            for(int i=0;i<listVentas.size();i++){
                if(listVentas.get(i).getCodigo().equals(codigoVenta)){
                    return listVentas.get(i);
                }
            }
            if(respuesta==false){
                System.out.println("venta no encontrada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Producto obtenerProducto(String codigoProducto) {
        for (Producto p : listProductos) {
            if (p.getCodigoProducto().equals(codigoProducto)) {
                return p;
            }
        }
        throw new RuntimeException("No encontrado" + codigoProducto);
    }

    public void venderProducto(Venta venta) {
        listVentas.add(venta);
    }


    public void registrarCliente(Cliente cliente) {

        try {
            if (listClientes.stream().anyMatch(cliente1 -> cliente1.getNumeroIdentificacion().equals(cliente.getNumeroIdentificacion()))) {
                System.out.println("El cliente ya esta registrado");
            } else {
                listClientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Cliente buscarClientePorCedula(String cedula) {
        Cliente cliente = null;
        for (Cliente c : listClientes) {
            if (c.getNumeroIdentificacion().equals(cedula)) {
                cliente = c;
                System.out.println("si existe");
                return cliente;

            }
        }
        return cliente;
    }

    public List<Venta> getListVentas() {
        return listVentas;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "listVentas=" + listVentas +
                ", listProductos=" + listProductos +
                ", listClientes=" + listClientes +
                '}';
    }
}
