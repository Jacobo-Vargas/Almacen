package org.example;

import model.*;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Almacen almacen = AlmacenInstance.INSTANCE.getAlmacen();
        almacen.registrarCliente(new ClientePersonaJuridica("Jacobo","Vargas","García","1094958613","Cerros del viento","3186569265","1094958613-1"));
        almacen.registrarCliente(new ClientePersonaNatural("Juan","Buitrago","piragua","1234567890","Barrio quindio","3112360897","juan123@gmail.com", LocalDate.of(2004,2,23)));
        almacen.registrarProducto(new ProductoEnvasado("01","crema","Crema para refrescar el cuerpo",10500,10,LocalDate.of(2023,1,15),500,PaisOrigen.COLOMBIA));
        almacen.registrarProducto(new ProductoRefrigerado("02","helado","Helado sabor a fresa",2900,25,"A01",-18));
        almacen.registrarProducto(new ProductoPerecedero("03","atun","Atun en aceite",7500,15,LocalDate.of(2024,5,24)));

        Venta venta = new Venta("01",LocalDate.now(), almacen.buscarClientePorCedula("1094958613"), 19);


        // consultar disponibilidad
        DetalleVenta detalle = new DetalleVenta(2,almacen.obtenerProducto("01"));
        DetalleVenta detalle1 = new DetalleVenta(2, almacen.obtenerProducto("03"));

        //añadir productos a canasta
        venta.getDetalleVenta().add(detalle);
        venta.getDetalleVenta().add(detalle1);

        // calcula subtotal y descuenta en inventario
        System.out.println();
        System.out.println(venta.calcularTotal());

        almacen.venderProducto(venta);

        System.out.println(almacen.getListVentas());

    }
}