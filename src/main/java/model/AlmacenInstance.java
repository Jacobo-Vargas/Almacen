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

    }

    public Almacen getAlmacen() {
        return almacen;
    }
}
