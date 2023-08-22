package model;
import model.Almacen;

import java.time.LocalDate;

public enum AlmacenInstance {
    INSTANCE;
    private final Almacen almacen;

    AlmacenInstance(){
        almacen = new Almacen();
        almacen.registrarProducto(new ProductoEnvasado("01","leche","pilas",2500,2, LocalDate.now(),45,PaisOrigen.COLOMBIA));
        almacen.registrarProducto(new ProductoEnvasado("02","pan","pilas",2500,2, LocalDate.now(),45,PaisOrigen.COLOMBIA));
        almacen.registrarCliente(new ClientePersonaJuridica("Jacobo", "Vargas", "García", "1094958613", "Cerros del viento", "3186569265", "1094958613-1"));
        almacen.registrarCliente(new ClientePersonaNatural("Juan", "Buitrago", "piragua", "1234567890", "Barrio quindio", "3112360897", "juan123@gmail.com", LocalDate.of(2004, 2, 23)));

        almacen.registrarProducto(new ProductoRefrigerado("04", "helado", "Helado sabor a fresa", 2900, 25, "A01", -18));
        almacen.registrarProducto(new ProductoPerecedero("03", "atun", "Atun en aceite", 7500, 15, LocalDate.of(2024, 5, 24)));

    }

    public Almacen getAlmacen() {
        return almacen;
    }
}
