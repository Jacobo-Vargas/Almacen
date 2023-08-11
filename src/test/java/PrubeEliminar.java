import model.Almacen;
import model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class PrubeEliminar {
    @Test
    public void pruebaUno(){
        Almacen almacen=new Almacen();
        Cliente cliente=new Cliente("juan","pablo","buitrago","123"
                ,"dsfs","3128638699");

        Cliente cliente2=new Cliente("juan","pablo","buitrago","321"
                ,"dsfs","3128638699");

        Cliente cliente3=new Cliente("juan","pablo","buitrago","5"
                ,"dsfs","3128638699");
        almacen.registrarCliente(cliente);
        almacen.registrarCliente(cliente2);
        almacen.registrarCliente(cliente3);


        System.out.println(almacen.getListClientes().size());
        Assertions.assertEquals(3,almacen.getListClientes().size());
        almacen.eliminarCliente("5");
        Assertions.assertEquals(2,almacen.getListClientes().size());
        System.out.println(almacen.getListClientes().size());

    }
    @Test
    public void pruebaDos(){
        Almacen almacen=new Almacen();
    }

}
