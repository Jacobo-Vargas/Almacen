package main;

import model.Almacen;
import model.AlmacenInstance;
import model.ClientePersonaJuridica;
import model.ClientePersonaNatural;
import model.DetalleVenta;
import model.PaisOrigen;
import model.ProductoEnvasado;
import model.ProductoPerecedero;
import model.ProductoRefrigerado;
import model.Venta;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //se abre el almacen
        Almacen almacen = AlmacenInstance.INSTANCE.getAlmacen();
        // se registran clientes
        almacen.registrarCliente(new ClientePersonaJuridica("Jacobo","Vargas","García","1094958613","Cerros del viento","3186569265","1094958613-1"));
        almacen.registrarCliente(new ClientePersonaNatural("Juan","Buitrago","piragua","1234567890","Barrio quindio","3112360897","juan123@gmail.com", LocalDate.of(2004,2,23)));

        // se registran productos
        //almacen.registrarProducto(new ProductoEnvasado("01","crema","Crema para refrescar el cuerpo",10500,10,LocalDate.of(2023,1,15),500,PaisOrigen.COLOMBIA));
        almacen.registrarProducto(new ProductoRefrigerado("02","helado","Helado sabor a fresa",2900,25,"A01",-18));
        almacen.registrarProducto(new ProductoPerecedero("03","atun","Atun en aceite",7500,15,LocalDate.of(2024,5,24)));


        // se añaden productos a canasta
        DetalleVenta detalle = new DetalleVenta(2,"01");
        DetalleVenta detalle1 = new DetalleVenta(2, "03");

        //se llevan a caja y se procesa venta
        Venta venta = new Venta(almacen.buscarClientePorCedula("1094958613"), 19);

        //se confirma compra
        venta.getDetalleVenta().add(detalle);
        venta.getDetalleVenta().add(detalle1);

        // calcula subtotal y descuenta en inventario
        System.out.println();
        System.out.println(venta.calcularTotal());

        // se almacena la venta
        almacen.venderProducto(venta);

        System.out.println(almacen.getListVentas());

    }
}