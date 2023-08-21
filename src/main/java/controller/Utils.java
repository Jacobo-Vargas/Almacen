package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.TextFormatter;
import model.Producto;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        alerta.setContentText("por favor verifique el producto.");
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
}
