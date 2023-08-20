package controller;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import model.Producto;

import java.time.LocalDate;
import java.util.ArrayList;


public class VentasController {
    @FXML
    public Button btnVender;
    @FXML
    public Button btnAdd;


    @FXML
    public TextField txtCedulaCliente;
    @FXML
    private TextField txtCantidadProductos;
    @FXML
    private TextField txtCodigoProducto;

    @FXML
    private TableColumn<Venta, String> clmCienteVenta;
    @FXML
    private TableColumn<Venta, String> clmCodigoVenta;
    @FXML
    private TableColumn<Venta, LocalDate> clmFechaVenta;
    @FXML
    private TableColumn<Venta, Float> clmIvaVenta;
    @FXML
    private TableColumn<Venta, Float> clmTotalVenta;


    @FXML
    private TableColumn<DetalleVenta,Integer> columnaCantidad;
    @FXML
    private TableColumn<DetalleVenta, String> columnaCodigoPoducto;
    @FXML
    private TableColumn<DetalleVenta, String> columnaProducto;
    @FXML
    private TableColumn<DetalleVenta, Float> columnaSubtotal;

    @FXML
    private Label lbTotal;



    @FXML
    private TableView<DetalleVenta> tablaDetalle;
    @FXML
    private TableView<Venta> tablaVentas;

    private ArrayList<DetalleVenta> detalles = new ArrayList<>();
    ObservableList<DetalleVenta> observableDetalleVenta;
    ObservableList<Venta> observableVenta;


    public void initialize() {

        AlmacenInstance.INSTANCE.getAlmacen().registrarCliente(new ClientePersonaJuridica("Jacobo","Vargas","García","1094958613","Cerros del viento","3186569265","1094958613-1"));
        AlmacenInstance.INSTANCE.getAlmacen().registrarCliente(new ClientePersonaNatural("Juan","Buitrago","piragua","1234567890","Barrio quindio","3112360897","juan123@gmail.com", LocalDate.of(2004,2,23)));

        AlmacenInstance.INSTANCE.getAlmacen().registrarProducto(new ProductoRefrigerado("02","helado","Helado sabor a fresa",2900,25,"A01",-18));
        AlmacenInstance.INSTANCE.getAlmacen().registrarProducto(new ProductoPerecedero("03","atun","Atun en aceite",7500,15,LocalDate.of(2024,5,24)));



        // se asignan los productos agregados a la lista observable
        observableDetalleVenta = FXCollections.observableArrayList();
        tablaDetalle.setItems(observableDetalleVenta);
        columnaCodigoPoducto.setCellValueFactory(new PropertyValueFactory<>("productoVendido"));
        columnaProducto.setCellValueFactory(cellData -> {
            String codigoProducto = cellData.getValue().getProductoVendido();
            String nombreProducto = consultarNombreProducto(codigoProducto);
            return new SimpleStringProperty(nombreProducto);
        });
        columnaSubtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidadProductos"));

        // se asignan las ventas a la lista observable de ventas
        observableVenta = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListVentas());
        tablaVentas.setItems(observableVenta);

        clmCienteVenta.setCellValueFactory(cellData -> {return new SimpleStringProperty(txtCedulaCliente.getText());});
        clmCodigoVenta.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        clmFechaVenta.setCellValueFactory(new PropertyValueFactory<>("fechaVenta"));
        clmIvaVenta.setCellValueFactory(new PropertyValueFactory<>("iva"));
        clmTotalVenta.setCellValueFactory(new PropertyValueFactory<>("total"));

    }


    @FXML
    void addDetalle() {
        DetalleVenta detalle = new DetalleVenta(Integer.parseInt(txtCantidadProductos.getText()), txtCodigoProducto.getText());
        System.out.println(detalle.getSubtotal());
        detalles.add(detalle);
        observableDetalleVenta.add(detalle);

        tablaDetalle.refresh();
        System.out.println("Se añadio");
    }


    @FXML
    void addVenta() {
        for (Cliente c: AlmacenInstance.INSTANCE.getAlmacen().getListClientes()) {
            if(c.getNumeroIdentificacion().equals(txtCedulaCliente.getText())){
                Venta venta = new Venta(c,19);

                // se le asigna la lista de detalles a la venta
                venta.setDetalleVenta(detalles);
                // se guarda la venta en el almacen
                AlmacenInstance.INSTANCE.getAlmacen().getListVentas().add(venta);

                System.out.println(AlmacenInstance.INSTANCE.getAlmacen().getListVentas().size());
                System.out.println(venta.calcularTotal());
                observableVenta.add(venta);
            }
        }
        detalles.clear();
        observableDetalleVenta.clear();

    }

    public String consultarNombreProducto(String codigoProducto){
        String nombreProducto = "";
        for (Producto p: AlmacenInstance.INSTANCE.getAlmacen().getListProductos()) {
            if(p.getCodigoProducto().equals(codigoProducto)){
                nombreProducto = p.getNombreProducto();
                break; //break para mejorar la eficiencia
            }
        }
        return nombreProducto;
    }

    public void productoSeleccionado(ActionEvent actionEvent) {

    }

    public void clienteSeleccionado(ActionEvent actionEvent) {

    }

    public ArrayList<DetalleVenta> getListaTemporal() {
        return detalles;
    }
}
