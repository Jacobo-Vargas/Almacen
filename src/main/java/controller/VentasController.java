package controller;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.*;
import model.Producto;
import static model.AlmacenInstance.INSTANCE;


public class VentasController {
    @FXML
    public ComboBox<String> productosComboBox;
    @FXML
    public TextField cantidadProductos;
    @FXML
    public ComboBox <String> clientesComboBox;
    @FXML
    public TableColumn<DetalleVenta, String> columnaProducto;
    @FXML
    public TableColumn<DetalleVenta, Integer> columnaCantidad;
    @FXML
    public TableColumn<DetalleVenta, Float> columnaSubtotal;
    @FXML
    public TableView tablaDetalle;
    @FXML
    public TableView tablaVentas;
    public TableColumn columnaCodigoPoducto;
    @FXML
    private Almacen almacen = AlmacenInstance.INSTANCE.getAlmacen();
    private Venta ventaActual;

    ObservableList<DetalleVenta> detalleVenta;


    public void initialize() {
        llenarComboBox();
    }

    public void llenarComboBox(){


        for (Producto p: almacen.getListProductos()) {
            productosComboBox.getItems().add(p.getNombreProducto());
        }
        for (Cliente c: almacen.getListClientes()) {
            clientesComboBox.getItems().add(c.getNumeroIdentificacion());
        }

        tablaDetalle.refresh();
        tablaVentas.refresh();
    }

    public void addDetalle(){
    }

    public void productoSeleccionado(ActionEvent actionEvent) {

    }

    public void clienteSeleccionado(ActionEvent actionEvent) {
    }
}
