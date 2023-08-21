package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReference;


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
    public TableView tableViewTablaMostrar;
    @FXML
    public TextField textFieldPeso;

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
    public DatePicker DatePickerFechaVencimiento;
    @FXML
    public DatePicker DatePickerFechaEnvasado;
    @FXML
    public TableColumn tableColumnPeso;
    @FXML
    public Button botonActulizar;
    @FXML
    ObservableList<Producto> productos;
    private Producto productoSelecionado;

    public void initialize() {
        productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
        tableViewTablaMostrar.setItems(productos);
        tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigoProducto"));
        tableColumnNombre.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        ;
        tableColumnDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcionProducto"));
        ;
        tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        //tableColumnPeso.setCellValueFactory(new PropertyValueFactory<>("pesoProducto"));
        ;
        existencia.setCellValueFactory(new PropertyValueFactory<>("cantidadExistente"));

        DatePickerFechaVencimiento.setVisible(false);
        textFieldPeso.setVisible(false);
        comboBoxPais.setVisible(false);
        DatePickerFechaVencimiento.setVisible(false);
        textFieldCodigoAprobacion.setVisible(false);
        textFieldTemratura.setVisible(false);
        DatePickerFechaEnvasado.setVisible(false);


        comboBoxTipoProducto.getItems().addAll(EnumProducto.values());
        comboBoxPais.getItems().addAll(PaisOrigen.values());


        tableViewTablaMostrar.setOnMouseClicked(even->{
            if(even.getClickCount()==1){
                Producto selecion= (Producto) tableViewTablaMostrar.getSelectionModel().getSelectedItem();
                productoSelecionado=selecion;
                textFieldCodigo.setText(selecion.getCodigoProducto());
                textFieldNombre.setText(selecion.getNombreProducto());
                textFieldDescripcion.setText(selecion.getDescripcionProducto());
                textFieldValor.setText(String.valueOf(selecion.getValorUnitario()));
                textFieldExistencia.setText(String.valueOf(selecion.getCantidadExistente()));

                if(selecion !=null){
                    System.out.println("selecion "+selecion.getNombreProducto());

                }
            }
        });

    }

    public void comboxEnvasado() {
        if (comboBoxTipoProducto.getValue() == EnumProducto.Envasado) {
            DatePickerFechaEnvasado.setVisible(true);
            textFieldPeso.setVisible(true);
            comboBoxPais.setVisible(true);
            DatePickerFechaVencimiento.setVisible(false);
            textFieldCodigoAprobacion.setVisible(false);
            textFieldTemratura.setVisible(false);
        } else if (comboBoxTipoProducto.getValue() == EnumProducto.Perecedero) {
            DatePickerFechaVencimiento.setVisible(true);
            DatePickerFechaEnvasado.setVisible(false);
            textFieldPeso.setVisible(false);
            comboBoxPais.setVisible(false);
            textFieldCodigoAprobacion.setVisible(false);
            textFieldTemratura.setVisible(false);

        } else if (comboBoxTipoProducto.getValue() == EnumProducto.Refrigerado) {
            textFieldCodigoAprobacion.setVisible(true);
            textFieldTemratura.setVisible(true);
            DatePickerFechaVencimiento.setVisible(false);
            DatePickerFechaEnvasado.setVisible(false);
            textFieldPeso.setVisible(false);
            comboBoxPais.setVisible(false);
        }
    }

    public void botonRegistrar() {
        if (comboBoxTipoProducto.getValue() == EnumProducto.Envasado) {
            String codigo = textFieldCodigo.getText();
            String nombre = textFieldNombre.getText();
            String descripcion = textFieldDescripcion.getText();

            String valor = textFieldValor.getText();
            String cantidad = textFieldExistencia.getText();
            String peso = textFieldPeso.getText();
            if(valor.isEmpty()|| cantidad.isEmpty() || peso.isEmpty()){
                Utils.alertaProductoError();
            }else{
                float valorr= Float.parseFloat(valor);
                int cantidadd= Integer.parseInt(cantidad);
                float pesoo= Float.parseFloat(peso);
                PaisOrigen pais = (PaisOrigen) comboBoxPais.getValue();
                LocalDate fechaEnvasado = DatePickerFechaEnvasado.getValue();
                ProductoEnvasado productoEnvasado = new ProductoEnvasado(codigo, nombre, descripcion, valorr, cantidadd, fechaEnvasado, pesoo, pais);
                AlmacenInstance.INSTANCE.getAlmacen().registrarProducto(productoEnvasado);
                productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
                tableViewTablaMostrar.setItems(productos);
            }


        } else if (comboBoxTipoProducto.getValue() == EnumProducto.Perecedero) {
            String codigo = textFieldCodigo.getText();
            String nombre = textFieldNombre.getText();
            String descripcion = textFieldDescripcion.getText();

            String valor = textFieldValor.getText();
            String cantidad = textFieldExistencia.getText();
            if(valor.isEmpty()|| cantidad.isEmpty()  ){
                Utils.alertaProductoError();
            }else{
                float valorr= Float.parseFloat(valor);
                int cantidadd= Integer.parseInt(cantidad);
                LocalDate fechaVencimiento = DatePickerFechaVencimiento.getValue();
                ProductoPerecedero productoPerecedero = new ProductoPerecedero(codigo, nombre, descripcion, valorr, cantidadd,
                        fechaVencimiento);
                AlmacenInstance.INSTANCE.getAlmacen().registrarProducto(productoPerecedero);
                productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
                tableViewTablaMostrar.setItems(productos);
            }

        } else if (comboBoxTipoProducto.getValue() == EnumProducto.Refrigerado) {
            String codigo = textFieldCodigo.getText();
            String nombre = textFieldNombre.getText();
            String descripcion = textFieldDescripcion.getText();


            String valor = textFieldValor.getText();
            String cantidad = textFieldExistencia.getText();
            if(valor.isEmpty()|| cantidad.isEmpty()  ){
                Utils.alertaProductoError();
            }else{
                float valorr= Float.parseFloat(valor);
                int cantidadd= Integer.parseInt(cantidad);
                String codigoAprobacion = textFieldCodigoAprobacion.getText();
                float temperatura = Float.parseFloat(textFieldTemratura.getText());
                ProductoRefrigerado productoRefrigerado = new ProductoRefrigerado(codigo, nombre, descripcion, valorr, cantidadd,
                        codigoAprobacion, temperatura);
                AlmacenInstance.INSTANCE.getAlmacen().registrarProducto(productoRefrigerado);
                productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
                tableViewTablaMostrar.setItems(productos);
            }


        }

        tableViewTablaMostrar.refresh();

    }

    public void buscarProducto() {
        DatePickerFechaEnvasado.setVisible(false);
        textFieldPeso.setVisible(false);
        comboBoxPais.setVisible(false);
        textFieldExistencia.setVisible(false);
        DatePickerFechaVencimiento.setVisible(false);
        textFieldCodigoAprobacion.setVisible(false);
        textFieldPeso.setVisible(false);
        textFieldNombre.setVisible(true);
        textFieldDescripcion.setVisible(false);
        textFieldValor.setVisible(false);
        String codigo = textFieldCodigo.getText();
        String nombre = textFieldNombre.getText();
        if (codigo.isEmpty() == false) {
            Producto producto = AlmacenInstance.INSTANCE.getAlmacen().buscarProductoCodigo(codigo);
            ObservableList<Producto> mostrar = FXCollections.singletonObservableList(producto);
            tableViewTablaMostrar.setItems(mostrar);
            Utils.alertaProductoBusqueda();
        } else if (nombre.isEmpty() == false) {
            Producto producto = AlmacenInstance.INSTANCE.getAlmacen().buscarProductoNombre(nombre);
            ObservableList<Producto> mostrar = FXCollections.singletonObservableList(producto);
            tableViewTablaMostrar.setItems(mostrar);
            Utils.alertaProductoBusqueda();
        }
    }

    public void restaurarTabla() {
        productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
        tableViewTablaMostrar.setItems(productos);
        textFieldCodigo.setVisible(true);
        textFieldNombre.setVisible(true);
        textFieldDescripcion.setVisible(true);
        textFieldValor.setVisible(true);
        textFieldExistencia.setVisible(true);
        tableViewTablaMostrar.setItems(productos);

        DatePickerFechaVencimiento.setVisible(false);
        DatePickerFechaEnvasado.setVisible(false);
        textFieldPeso.setVisible(false);
        comboBoxPais.setVisible(false);
        textFieldCodigoAprobacion.setVisible(false);
        textFieldTemratura.setVisible(false);

        textFieldCodigo.clear();
        textFieldNombre.clear();
        textFieldDescripcion.clear();
        textFieldValor.clear();
        textFieldExistencia.clear();
        DatePickerFechaEnvasado.setValue(null);
        DatePickerFechaVencimiento.setValue(null);


    }

    public void botonEliminar() {
        textFieldDescripcion.setVisible(false);
        textFieldValor.setVisible(false);
        textFieldExistencia.setVisible(false);
        DatePickerFechaEnvasado.setVisible(false);
        textFieldPeso.setVisible(false);
        comboBoxPais.setVisible(false);
        if (textFieldCodigo.getText().isEmpty() == false) {
            System.out.println(AlmacenInstance.INSTANCE.getAlmacen().getListProductos().size());
            AlmacenInstance.INSTANCE.getAlmacen().eliminarProductoCodigo(textFieldCodigo.getText());
            productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
            tableViewTablaMostrar.setItems(productos);


        } else if (textFieldNombre.getText().isEmpty() == false) {
            AlmacenInstance.INSTANCE.getAlmacen().eliminarProductoNombre(textFieldNombre.getText());
            tableViewTablaMostrar.refresh();
            productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
            tableViewTablaMostrar.setItems(productos);
        }
        tableViewTablaMostrar.refresh();

    }
    public void actualizarProducto(){
        boolean anuncio=false;
        boolean  no=false;
        textFieldCodigo.setVisible(true);
        textFieldNombre.setVisible(true);
        textFieldDescripcion.setVisible(true);
        textFieldValor.setVisible(true);
        textFieldExistencia.setVisible(true);
        int indice = 0;
        String codigo=textFieldCodigo.getText();
        String nombre=textFieldNombre.getText();
        String descripcion=textFieldDescripcion.getText();
        float valor= Float.parseFloat(textFieldValor.getText());
        int existencia= Integer.parseInt(textFieldExistencia.getText());


        textFieldCodigoAprobacion.setVisible(false);
        textFieldTemratura.setVisible(false);
        comboBoxPais.setVisible(false);
        DatePickerFechaVencimiento.setVisible(false);
        DatePickerFechaEnvasado.setVisible(false);
        if(productoSelecionado.getCodigoProducto() !=codigo){
            no=true;
        }






        if(productoSelecionado.getNombreProducto() !=nombre){
            for (int i=0;i<AlmacenInstance.INSTANCE.getAlmacen().getListProductos().size();i++){
                if(productoSelecionado.getCodigoProducto().equals(AlmacenInstance.INSTANCE.getAlmacen().getListProductos().get(i).getCodigoProducto())){
                    indice=i;
                }
            }
            AlmacenInstance.INSTANCE.getAlmacen().modificarProducotNombre(nombre,indice);
            anuncio=true;

        }
         if(productoSelecionado.getDescripcionProducto() !=descripcion){
            for (int i=0;i<AlmacenInstance.INSTANCE.getAlmacen().getListProductos().size();i++){
                if(productoSelecionado.getCodigoProducto().equals(AlmacenInstance.INSTANCE.getAlmacen().getListProductos().get(i).getCodigoProducto())){
                    indice=i;
                }
            }
            AlmacenInstance.INSTANCE.getAlmacen().modificarProducotDescrpcio(descripcion,indice);
            anuncio=true;
        }
         if(productoSelecionado.getValorUnitario() !=valor){
            for (int i=0;i<AlmacenInstance.INSTANCE.getAlmacen().getListProductos().size();i++){
                if(productoSelecionado.getCodigoProducto().equals(AlmacenInstance.INSTANCE.getAlmacen().getListProductos().get(i).getCodigoProducto())){
                    indice=i;
                }
            }
            AlmacenInstance.INSTANCE.getAlmacen().modificarProducotPrecio(valor,indice);
            anuncio=true;

        }
        if(productoSelecionado.getCantidadExistente() !=existencia){
            for (int i=0;i<AlmacenInstance.INSTANCE.getAlmacen().getListProductos().size();i++){
                if(productoSelecionado.getCodigoProducto().equals(AlmacenInstance.INSTANCE.getAlmacen().getListProductos().get(i).getCodigoProducto())){
                    indice=i;
                }
            }
            AlmacenInstance.INSTANCE.getAlmacen().modificarProducotExistencia(existencia,indice);
            anuncio=true;

        }
        if(anuncio==true){
            Utils.alertaProductoActulizado();
        }

        productos = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListProductos());
        tableViewTablaMostrar.setItems(productos);
        tableViewTablaMostrar.refresh();

    }
}
