package controller;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import model.Producto;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;


public class VentasController {
    @FXML
    public Button btnVender;
    @FXML
    public Button btnAdd;
    @FXML
    public Button btnVaciar;


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
    private TableColumn<DetalleVenta, Integer> columnaCantidad;
    @FXML
    private TableColumn<DetalleVenta, String> columnaCodigoPoducto;
    @FXML
    private TableColumn<DetalleVenta, String> columnaProducto;
    @FXML
    private TableColumn<DetalleVenta, Float> columnaSubtotal;


    @FXML
    private TableView<DetalleVenta> tablaDetalle;
    @FXML
    private TableView<Venta> tablaVentas;

    private final ArrayList<DetalleVenta> detalles = new ArrayList<>();
    ObservableList<DetalleVenta> observableDetalleVenta;
    ObservableList<Venta> observableVenta;


    public void initialize() {

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

        clmCienteVenta.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(txtCedulaCliente.getText());
        });
        clmCodigoVenta.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        clmFechaVenta.setCellValueFactory(new PropertyValueFactory<>("fechaVenta"));
        clmIvaVenta.setCellValueFactory(new PropertyValueFactory<>("iva"));
        clmTotalVenta.setCellValueFactory(new PropertyValueFactory<>("total"));

    }


    @FXML
    void addDetalle() {
        try {

            if (txtCodigoProducto.getText().isEmpty() || txtCantidadProductos.getText().isEmpty() || txtCedulaCliente.getText().isEmpty()) {
                Utils.mostrarAlertaCamposVacios();
            } else if (!(Utils.verificarProducto(txtCodigoProducto.getText()))) {
                Utils.alertaProducto();
            } else if (!(Utils.verificarCedula(txtCedulaCliente.getText()))) {
                Utils.alertaCedula();
            } else if (!(Utils.verificarExistencia(txtCodigoProducto.getText(), Integer.parseInt(txtCantidadProductos.getText())))) {
                Utils.alertaCantidadSuperada();
            } else {
                DetalleVenta detalle = new DetalleVenta(Integer.parseInt(txtCantidadProductos.getText()), txtCodigoProducto.getText());
                System.out.println(detalle.getSubtotal());
                detalles.add(detalle);
                observableDetalleVenta.add(detalle);
                tablaDetalle.refresh();
                txtCedulaCliente.setDisable(true);

            }


        } catch (Exception e) {
          if (!(Utils.esCompatibleNumeros(txtCedulaCliente.getText()))) {
                Utils.alertaCedula();
            } else if (!(Utils.esCompatibleNumeros(txtCantidadProductos.getText()))) {
                Utils.alertaCantidad();
            }

        }

    }


    @FXML
    void addVenta() throws IOException {
        if (!detalles.isEmpty()) {
            for (Cliente c: AlmacenInstance.INSTANCE.getAlmacen().getListClientes()) {
                if (c.getNumeroIdentificacion().equals(txtCedulaCliente.getText())) {
                    Venta venta = new Venta(c, 19);

                    // se le asigna la lista de detalles a la venta
                    venta.setDetalleVenta(detalles);
                    // se guarda la venta en el almacen
                    AlmacenInstance.INSTANCE.getAlmacen().getListVentas().add(venta);

                    // este util descuenta los productos de inventario
                    Utils.descontar(txtCodigoProducto.getText(),txtCantidadProductos.getText());


                    System.out.println(AlmacenInstance.INSTANCE.getAlmacen().getListVentas().size());
                    System.out.println(venta.calcularTotal());
                    observableVenta.add(venta);
                    GenerarReporte.generarPDFVenta(venta);
                    txtCedulaCliente.setDisable(false);
                }
            }
            removeItems();
        } else {
            Utils.mostrarAlertaCanastaVacia();
        }
    }

    @FXML
    void removeItems() {
        if (detalles.isEmpty()) {
            Utils.alertaListaVacia();
        } else {
            detalles.clear();
            observableDetalleVenta.clear();
            txtCedulaCliente.setDisable(false);
        }

    }


    public String consultarNombreProducto(String codigoProducto) {
        String nombreProducto = "";
        for (Producto p : AlmacenInstance.INSTANCE.getAlmacen().getListProductos()) {
            if (p.getCodigoProducto().equals(codigoProducto)) {
                nombreProducto = p.getNombreProducto();
                break; //break para mejorar la eficiencia
            }
        }
        return nombreProducto;
    }


}
