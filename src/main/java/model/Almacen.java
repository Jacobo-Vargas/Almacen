package model;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private static List<Venta> listVentas = new ArrayList<>();
    private static List<Producto> listProductos = new ArrayList<>();
    private static List<Cliente> listClientes = new ArrayList<>();

    public Almacen() {
    }

    public void registrarProducto(Producto producto) {
        try {
            if (listProductos.stream().anyMatch(producto1 -> producto1.getCodigoProducto().equals(producto.getCodigoProducto()))) {
                System.out.println("El codigo ya existe");
            } else {
                listProductos.add(producto);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

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

    public void venderProducto(Venta venta) {
        listVentas.add(venta);
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
