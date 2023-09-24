package model;

import controller.Utils;

import java.time.LocalDate;
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
                Utils.alertaProductoExistente();
            } else {
                listProductos.add(producto);
                Utils.alertaProductoAgregadoExito();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void eliminarClienteIdentificacion(String numeroIdentificacion) {//Metodo para eliminar cliente
        // de la lista Cliente
        boolean respuesta = false;
        try {
            for (int i = 0; i < listClientes.size(); i++) {
                if (listClientes.get(i).getNumeroIdentificacion().equals(numeroIdentificacion)) {
                    respuesta = true;
                    listClientes.remove(listClientes.get(i));
                }
            }
            if (!respuesta) {
                System.out.println("Cliente no encontrad0");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void eliminarProductoCodigo(String codigo) {//metodo para eliminar un producto por medio del codogo,
        // elimina de la lista producto
        boolean respuesta = false;
        try {
            for (int i = 0; i < listProductos.size(); i++) {
                if (listProductos.get(i).getCodigoProducto().equals(codigo)) {
                    listProductos.remove(listProductos.get(i));
                    respuesta = true;
                }
            }
            if (!respuesta) {
                System.out.println("Codigo no encontrado");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarProductoNombre(String codigo) {//metodo para eliminar un producto por medio del codogo,
        // elimina de la lista producto
        boolean respuesta = false;
        try {
            for (int i = 0; i < listProductos.size(); i++) {
                if (listProductos.get(i).getNombreProducto().equals(codigo)) {
                    listProductos.remove(listProductos.get(i));
                    respuesta = true;
                }
            }
            if (!respuesta) {
                System.out.println("Nombre no encontrado");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarVenta(int codigo) {//metodo para eliminar las ventas registradas, las elimina de las listas
        boolean respuesta = false;
        try {
            for (int i = 0; i < listVentas.size(); i++) {
                if (listVentas.get(i).getCodigo() == codigo) {
                    listVentas.remove(listVentas.get(i));
                    System.out.println("venta elimida");
                    respuesta = true;
                }
            }
            if (!respuesta) {
                System.out.println("venta no encontrada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Venta buscarVentaCodigo(int codigoVenta) {//metodo para la busqueda de una venta mediante su codigo
        boolean respuesta = false;
        try {
            for (int i = 0; i < listVentas.size(); i++) {
                if (listVentas.get(i).getCodigo() == codigoVenta) {
                    return listVentas.get(i);
                }
            }
            if (!respuesta) {
                System.out.println("venta no encontrada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Producto buscarProductoCodigo(String codigoProducto) {//metodo para la busqueda de una venta mediante su codigo
        boolean respuesta = false;
        try {
            for (int i = 0; i < listProductos.size(); i++) {
                if (listProductos.get(i).getCodigoProducto().equals(codigoProducto)) {
                    return listProductos.get(i);
                }
            }
            if (!respuesta) {
                System.out.println("codigo no encontrada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Producto buscarProductoNombre(String nombre) {//metodo para la busqueda de una venta mediante su codigo
        boolean respuesta = false;
        try {
            for (int i = 0; i < listProductos.size(); i++) {
                if (listProductos.get(i).getNombreProducto().equals(nombre) ) {
                    return listProductos.get(i);
                }
            }
            if (!respuesta) {
                System.out.println("codigo no encontrada");
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

    public void setListVentas(ArrayList<Venta> listVentas) {
        this.listVentas = listVentas;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(ArrayList<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(ArrayList<Cliente> listClientes) {
        this.listClientes = listClientes;
    }


  public void modificarProducotNombre(String nombre,int i){
        getListProductos().get(i).setNombreProducto(nombre);
  }
    public void modificarProducotDescrpcio(String descripcion,int i){
        getListProductos().get(i).setDescripcionProducto(descripcion);
    }
    public void modificarProducotPrecio(float precio,int i){
        getListProductos().get(i).setValorUnitario(precio);
    }
    public void modificarProducotExistencia(int cantidad,int i){
        getListProductos().get(i).setCantidadExistente(cantidad);
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
