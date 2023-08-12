import model.Almacen;
import model.ClientePersonaJuridica;
import model.ClientePersonaNatural;
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

}
