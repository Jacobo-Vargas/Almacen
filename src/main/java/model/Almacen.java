package model;

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
    public Producto buscarProductoExistencia(int existencia) {//metodo para la busqueda de una venta mediante su codigo
        boolean respuesta = false;
        try {
            for (int i = 0; i < listProductos.size(); i++) {
                if (listProductos.get(i).getCantidadExistente() == existencia) {
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
        boolean bandera = false;
        try {

            for (Cliente c : listClientes) {
                if (c.getNumeroIdentificacion().equals(cliente.getNumeroIdentificacion())) {
                    bandera = true;
                    break;
                }

            }
            if(!bandera ){
                listClientes.add(cliente);
                System.out.println("Cliente registrado");
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
    public void actualizarProductoNombre(Producto producto){
        for(int i=0 ; i<listProductos.size();i++){
            if(producto.getNombreProducto().equals(AlmacenInstance.INSTANCE.getAlmacen().getListProductos().get(i).getNombreProducto())){
                AlmacenInstance.INSTANCE.getAlmacen().listProductos.remove(AlmacenInstance.INSTANCE.getAlmacen().listProductos.get(i));
                AlmacenInstance.INSTANCE.getAlmacen().registrarProducto(producto);
            }
        }

    }
    public void actualizarProductoNombreDescripcion(Producto producto){
        for(int i=0 ; i<listProductos.size();i++){
            if(producto.getDescripcionProducto().equals(AlmacenInstance.INSTANCE.getAlmacen().getListProductos().get(i).getDescripcionProducto())){
                AlmacenInstance.INSTANCE.getAlmacen().listProductos.remove(AlmacenInstance.INSTANCE.getAlmacen().listProductos.get(i));
                AlmacenInstance.INSTANCE.getAlmacen().registrarProducto(producto);
            }
        }

    }
  //  public void actualizarProductoValor(Producto producto){
    //    for(int i=0 ; i<listProductos.size();i++){
       //     if(producto.getValorUnitario()==AlmacenInstance.INSTANCE.getAlmacen().getListProductos().get(i).getValorUnitario()){
         //       AlmacenInstance.INSTANCE.getAlmacen().getListProductos().get(i).setNombreProducto();
           // }
        //}

    //}//

    @Override
    public String toString() {
        return "Almacen{" +
                "listVentas=" + listVentas +
                ", listProductos=" + listProductos +
                ", listClientes=" + listClientes +
                '}';
    }
}
