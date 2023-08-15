import model.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TestRegistrarClientes {
    @Test
    public void testClienteNatural(){
        Almacen almacen = new Almacen();
        almacen.registrarCliente(new ClientePersonaNatural("Juan","Buitrago","piragua","1234567890","Barrio quindio","3112360897","juan123@gmail.com", LocalDate.of(2004,2,23)));

    }
    @Test
    public void testClienteJuridico(){
        Almacen almacen = new Almacen();
        almacen.registrarCliente(new ClientePersonaJuridica("Jacobo","Vargas","García","1094958613","Cerros del viento","3186569265","1094958613-1"));

    }
    @Test
    public void testBuscarCodigo(){
        Almacen almacen = new Almacen();

        Venta venta=new Venta("123",null,null,3);
        Venta venta2=new Venta("321",null,null,3);
        Venta venta3=new Venta("444",null,null,3);
        almacen.venderProducto(venta);
        almacen.venderProducto(venta2);
        almacen.venderProducto(venta3);
        Assert.assertEquals(venta2,almacen.buscarVentaCodigo("321"));
    }
    @Test
    public void testEliminarVenta(){
        Almacen almacen = new Almacen();

        Venta venta=new Venta("123",null,null,3);
        Venta venta2=new Venta("321",null,null,3);
        Venta venta3=new Venta("444",null,null,3);
        almacen.venderProducto(venta);
        almacen.venderProducto(venta2);
        almacen.venderProducto(venta3);
        almacen.getListVentas().forEach(System.out::println);
        almacen.eliminarVenta("444");
        System.out.println("////////////////////////////////////////////////////");
        almacen.getListVentas().forEach(System.out::println);
        Assert.assertEquals(2,almacen.getListVentas().size());

    }
    @Test
    public void testEliminarCliente(){
        Almacen almacen = new Almacen();

        almacen.registrarCliente(new Cliente("Juan pablo","buitrago","Piragua",
                "1090","33","d"));
        almacen.registrarCliente(new Cliente("Juan pablo","buitrago","Piragua",
                "123","33","d"));
        almacen.registrarCliente(new Cliente("Juan pablo","buitrago","Piragua",
                "444","33","d"));
        System.out.println(almacen.getListClientes().size());
        almacen.getListClientes().forEach(System.out::println);
        System.out.println("/////////////////////////////////////////////////////");
        almacen.eliminarClienteIdentificacion("123");
        almacen.getListClientes().forEach(System.out::println);
        System.out.println(almacen.getListClientes().size());
        Assert.assertEquals(2,almacen.getListClientes().size());

    }


}
