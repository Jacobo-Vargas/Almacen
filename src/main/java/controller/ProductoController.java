package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

import java.time.LocalDate;


public class ProductoController {
    @FXML
    public Button botonAgregar;
    @FXML
    public Button botonBuscar;
    @FXML
    public Button botonEliminar;
    @FXML

    public TextField textFieldCodigo;
    @FXML
    public TextField textFieldDescripcion;
    @FXML
    public TextField textFieldValor;
    @FXML
    public TextField textFieldNombre;
    @FXML
    public TextField textFieldExistencia;
    @FXML
    public TextField textFieldFechaEnvasado;
    @FXML
    public TableView tableViewTablaMostrar;
    @FXML
    public TextField textFieldPeso;
    @FXML
    public TextField textFieldFechaVencimiento;
    @FXML
    public TextField textFieldCodigoAprobacion;
    @FXML
    public TextField textFieldTemratura;
    @FXML
    public ComboBox comboBoxPais;
    @FXML
    public ComboBox comboBoxTipoProducto;
    @FXML

    public TableColumn tableColumnCodigo;
    @FXML
    public TableColumn tableColumnNombre;
    @FXML
    public TableColumn tableColumnDescripcion;
    @FXML
    public TableColumn tableColumnValor;
    @FXML
    public TableColumn existencia;
    @FXML
    ObservableList<Producto> productos;

    public void initialize() {
        productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
        tableViewTablaMostrar.setItems(productos);
        tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigoProducto"));
        tableColumnNombre.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        ;
        tableColumnDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcionProducto"));
        ;
        tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        ;
        existencia.setCellValueFactory(new PropertyValueFactory<>("cantidadExistente"));
        textFieldFechaVencimiento.setVisible(false);
        textFieldPeso.setVisible(false);
        comboBoxPais.setVisible(false);
        textFieldFechaVencimiento.setVisible(false);
        textFieldCodigoAprobacion.setVisible(false);
        textFieldTemratura.setVisible(false);
        textFieldFechaEnvasado.setVisible(false);
        comboBoxTipoProducto.getItems().addAll(EnumProducto.values());
        comboBoxPais.getItems().addAll(PaisOrigen.values());
    }

    public void comboxEnvasado() {
        if (comboBoxTipoProducto.getValue() == EnumProducto.Envasado) {
            textFieldFechaEnvasado.setVisible(true);
            textFieldPeso.setVisible(true);
            comboBoxPais.setVisible(true);
            textFieldFechaVencimiento.setVisible(false);
            textFieldCodigoAprobacion.setVisible(false);
            textFieldTemratura.setVisible(false);
        } else if (comboBoxTipoProducto.getValue() == EnumProducto.Perecedero) {
            textFieldFechaVencimiento.setVisible(true);
            textFieldFechaEnvasado.setVisible(false);
            textFieldPeso.setVisible(false);
            comboBoxPais.setVisible(false);
            textFieldCodigoAprobacion.setVisible(false);
            textFieldTemratura.setVisible(false);

        } else if (comboBoxTipoProducto.getValue() == EnumProducto.Refrigerado) {
            textFieldCodigoAprobacion.setVisible(true);
            textFieldTemratura.setVisible(true);
            textFieldFechaVencimiento.setVisible(false);
            textFieldFechaEnvasado.setVisible(false);
            textFieldPeso.setVisible(false);
            comboBoxPais.setVisible(false);
        }
    }

    public void botonRegistrar() {
        if (comboBoxTipoProducto.getValue() == EnumProducto.Envasado) {
            String codigo = textFieldCodigo.getText();
            String nombre = textFieldNombre.getText();
            String descripcion = textFieldDescripcion.getText();
            float valor = Float.parseFloat(textFieldValor.getText());
            int cantidad = Integer.parseInt(textFieldExistencia.getText());
            LocalDate fecha = LocalDate.now();
            float peso = Float.parseFloat(textFieldPeso.getText());
            PaisOrigen pais = (PaisOrigen) comboBoxPais.getValue();
            ProductoEnvasado productoEnvasado = new ProductoEnvasado(codigo, nombre, descripcion, valor, cantidad, fecha, peso, pais);
            AlmacenInstance.INSTANCE.getAlmacen().registrarProducto(productoEnvasado);
            productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
            tableViewTablaMostrar.setItems(productos);

        } else if (comboBoxTipoProducto.getValue() == EnumProducto.Perecedero) {
            String codigo = textFieldCodigo.getText();
            String nombre = textFieldNombre.getText();
            String descripcion = textFieldDescripcion.getText();
            float valor = Float.parseFloat(textFieldValor.getText());
            int cantidad = Integer.parseInt(textFieldExistencia.getText());
            LocalDate fechaVencimiento = LocalDate.now();
            ProductoPerecedero productoPerecedero = new ProductoPerecedero(codigo, nombre, descripcion, valor, cantidad,
                    fechaVencimiento);
            AlmacenInstance.INSTANCE.getAlmacen().registrarProducto(productoPerecedero);
            productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
            tableViewTablaMostrar.setItems(productos);
        } else if (comboBoxTipoProducto.getValue() == EnumProducto.Refrigerado) {
            String codigo = textFieldCodigo.getText();
            String nombre = textFieldNombre.getText();
            String descripcion = textFieldDescripcion.getText();
            float valor = Float.parseFloat(textFieldValor.getText());
            int cantidad = Integer.parseInt(textFieldExistencia.getText());
            String codigoAprobacion = textFieldCodigoAprobacion.getText();
            float temperatura = Float.parseFloat(textFieldTemratura.getText());
            ProductoRefrigerado productoRefrigerado = new ProductoRefrigerado(codigo, nombre, descripcion, valor, cantidad,
                    codigoAprobacion, temperatura);
            AlmacenInstance.INSTANCE.getAlmacen().registrarProducto(productoRefrigerado);
            productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
            tableViewTablaMostrar.setItems(productos);
        }

    }

    public void buscarProducto() {
        textFieldFechaEnvasado.setVisible(false);
        textFieldPeso.setVisible(false);
        comboBoxPais.setVisible(false);
        textFieldFechaVencimiento.setVisible(false);
        textFieldCodigoAprobacion.setVisible(false);
        textFieldPeso.setVisible(false);
        textFieldNombre.setVisible(false);
        textFieldDescripcion.setVisible(false);
        textFieldValor.setVisible(false);
        String codigo = textFieldCodigo.getText();
        String existencia = textFieldExistencia.getText();
        if (codigo.isEmpty() == false) {
            Producto producto = AlmacenInstance.INSTANCE.getAlmacen().buscarProductoCodigo(codigo);
            ObservableList<Producto> mostrar = FXCollections.singletonObservableList(producto);
            tableViewTablaMostrar.setItems(mostrar);
        } else if (existencia.isEmpty() == false) {
            Producto producto = AlmacenInstance.INSTANCE.getAlmacen().buscarProductoExistencia(Integer.parseInt(existencia));
            ObservableList<Producto> mostrar = FXCollections.singletonObservableList(producto);
            tableViewTablaMostrar.setItems(mostrar);
        }
    }

    public void restaurarTabla() {
        productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
        tableViewTablaMostrar.setItems(productos);
        textFieldNombre.setVisible(true);
        textFieldDescripcion.setVisible(true);
        textFieldValor.setVisible(true);

    }
}
