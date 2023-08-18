package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private List<Venta> listVentas = new ArrayList<>();
    private List<Producto> listProductos = new ArrayList<>();
    private List<Cliente> listClientes = new ArrayList<>();

    public Almacen() {


        registrarCliente(new ClientePersonaJuridica("Jacobo","Vargas","García","1094958613","Cerros del viento","3186569265","1094958613-1"));
        registrarCliente(new ClientePersonaNatural("Juan","Buitrago","piragua","1234567890","Barrio quindio","3112360897","juan123@gmail.com", LocalDate.of(2004,2,23)));

        // se registran productos
        registrarProducto(new ProductoEnvasado("01","crema","Crema para refrescar el cuerpo",10500,10,LocalDate.of(2023,1,15),500,PaisOrigen.COLOMBIA));
        registrarProducto(new ProductoRefrigerado("02","helado","Helado sabor a fresa",2900,25,"A01",-18));
        registrarProducto(new ProductoPerecedero("03","atun","Atun en aceite",7500,15,LocalDate.of(2024,5,24)));

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
                    listProductos.remove(listVentas.get(i));
                    respuesta = true;
                }
            }
            if (!respuesta) {
                System.out.println("producto no encontrado");
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

    @Override
    public String toString() {
        return "Almacen{" +
                "listVentas=" + listVentas +
                ", listProductos=" + listProductos +
                ", listClientes=" + listClientes +
                '}';
    }
}
