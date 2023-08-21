package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.TextFormatter;
import model.AlmacenInstance;
import model.Producto;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static model.AlmacenInstance.INSTANCE;

public class Utils {
    Utils() {

    }

    public static void mostrarAlertaCanastaVacia() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("No hay productos");
        alerta.setHeaderText("Canasta vacia");
        alerta.setContentText("por favor registre al menos un producto");
        alerta.showAndWait();
    }
    public static void mostrarAlertaCamposVacios() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("LLENE LOS CAMPOS");
        alerta.setHeaderText("Campos vacios");
        alerta.setContentText("por favor asegurese de diligenciar todos los campos.");
        alerta.showAndWait();
    }

    public static void alertaCedula() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("CEDULA INVALIDA");
        alerta.setHeaderText("Cedula");
        alerta.setContentText("por favor verifique el numero de cedula que sea correcto, solo se aceptan numeros sin espacios ni comas.");
        alerta.showAndWait();
    }

    public static void alertaProducto() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("PRODUCTO INVALIDO");
        alerta.setHeaderText("Producto");
        alerta.setContentText("No se puede cambiar el codigo del producto");
        alerta.showAndWait();
    }
    public static void alertaProductoBusqueda() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("PRODUCTO ENCONTRADO ");
        alerta.setHeaderText("Producto");
        alerta.setContentText("Producto encontrado con exito");
        alerta.showAndWait();
    }


    public static void alertaProductoError() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("PRODUCTO NO AGREGADO");
        alerta.setHeaderText("Producto");
        alerta.setContentText("no se puede agregar el producto verifique los campos");
        alerta.showAndWait();
    }
    public static void alertaProductoActulizado() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("PRODUCTO ACTUALIZADO");
        alerta.setHeaderText("Producto");
        alerta.setContentText("Producto actualizado con exito");
        alerta.showAndWait();
    }
    public static void alertaProductoAgregadoExito() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("PRODUCTO AGREGADO");
        alerta.setHeaderText("Producto");
        alerta.setContentText("El producto se agrego correctamente");
        alerta.showAndWait();
    }
    public static void alertaProductoExistente() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("PRODUCTO YA EXISTENTE");
        alerta.setHeaderText("Producto");
        alerta.setContentText("El producto ya existe");
        alerta.showAndWait();
    }

    public static void alertaCantidad() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("CANTIDAD INVALIDA");
        alerta.setHeaderText("Cantidad");
        alerta.setContentText("por favor verifique la cantidad de productos, solo se aceptan numeros sin espacios ni comas.");
        alerta.showAndWait();
    }

    public static void alertaListaVacia() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("No hay productos");
        alerta.setHeaderText("Canasta vacia");
        alerta.setContentText("no existen productos en la canasta");
        alerta.showAndWait();
    }

    public static void alertaCantidadSuperada() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("CANTIDAD NO DISPONIBLE");
        alerta.setHeaderText("Producto insuficiente");
        alerta.setContentText("la cantidad de productos supera los produtos disponibles.");
        alerta.showAndWait();
    }
    public static TextFormatter.Change upperCaseFormat(TextFormatter.Change change) {
        change.setText(change.getText().toUpperCase());
        return change;
    }

    public static TextFormatter.Change integerFormat(TextFormatter.Change change) {
        if (change.getText().matches("[0-9]*")) {
            return change;
        }
        return null;
    }

    public static TextFormatter.Change decimalFormat(TextFormatter.Change change) {
        if (change.getControlNewText().matches("^\\d*\\.\\d+|\\d+\\.\\d*|\\d*$")) {
            return change;
        }
        return null;
    }

    public  static boolean verificarExistencia(String producto,int numero){
        boolean verificacion = false;
        for (Producto p: INSTANCE.getAlmacen().getListProductos()) {
            if((p.getCodigoProducto().equals(producto)) && (p.getCantidadExistente() >= numero)){
                verificacion = true;
                break;
            }
        }
        return verificacion;
    }

    public static boolean verificarProducto(String product){
        return INSTANCE.getAlmacen().getListProductos()
                .stream().anyMatch(producto -> producto.getCodigoProducto().equals(product));
    }
    public static boolean verificarCedula(String cedula){
        return INSTANCE.getAlmacen().getListClientes()
                .stream().anyMatch(cliente -> cliente.getNumeroIdentificacion().equals(cedula));
    }

    // metodo que me verifica si solo existen numeros en una cadena de texto
    public static boolean esCompatibleNumeros(String txt) {

        // Define la expresión regular para buscar solo numeros
        String patronNumeros = "^[0-9]+$";

        Pattern pattern = Pattern.compile(patronNumeros);
        Matcher matcher = pattern.matcher(txt);

        return matcher.matches();
    }

    public static void descontar(String producto,String cantidad){
        for (Producto p: AlmacenInstance.INSTANCE.getAlmacen().getListProductos()) {
            if(p.getCodigoProducto().equals(producto)){
                p.setCantidadExistente(p.getCantidadExistente()-parseInt(cantidad));
            }
        }
    }
    public static boolean verificarTexto(String nombre){

        String regex = "^[a-zA-Z]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nombre);

        return matcher.matches();


    }

    public static boolean verificarEspacios(String nombre){

        String regex = "^[^\\s]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nombre);

        return matcher.matches();


    }

}
