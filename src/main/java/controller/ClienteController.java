package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import static model.AlmacenInstance.INSTANCE;

import java.time.LocalDate;

public class ClienteController {

    @FXML
    public TextField textFieldNombre;

    @FXML
    private TextField textFieldCorreo;

    @FXML
    private TextField textFieldDireccion;

    @FXML
    private TextField textFieldDocumento;

    @FXML
    private TextField textFieldNit;

    @FXML
    private TextField textFieldPrimerApellido;

    @FXML
    private TextField textFieldSegundoApellido;

    @FXML
    private TextField textFieldTelefono;

    public ComboBox<EnumTipoPersona> comboBoxTipoPersona;

    @FXML
    public DatePicker DatePickerFechaNacimiento;
    @FXML
    public TableView<Cliente> tableViewTablaMostrar;
    @FXML
    public TableColumn<Cliente, String> tableColumnNombre;
    @FXML
    public TableColumn<Cliente, String> tableColumnApellido;
    @FXML
    public TableColumn<Cliente, String> tableColumnDocumento;
    @FXML
    public TableColumn<Cliente, String> tableColumnDireccion;
    @FXML
    public TableColumn<Cliente, String> tableColumnTelefono;
    @FXML
    public TableColumn<Cliente, String> tableColumnTipoPersona;
    @FXML
    public TableColumn<Cliente, String> tableColumnCorreo;
    @FXML
    public TableColumn<Cliente, DatePicker> tableColumnFechaNacimiento;


    //public TextField textFieldNit;
    @FXML
    public Button btnRegistrar;
    @FXML
    public Button btnEliminar;

    @FXML
    public DatePicker textFieldFechaNacimiento;
    @FXML
    public Button btnActualizar;
    @FXML
    public Button btnBuscar;

    @FXML
    ObservableList<Cliente> cliente;


    public void initialize() {


        cliente = FXCollections.observableArrayList(AlmacenInstance.INSTANCE.getAlmacen().getListClientes());
        tableViewTablaMostrar.setItems(cliente);
        tableColumnNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        tableColumnApellido.setCellValueFactory(new PropertyValueFactory<>("apellidoUno"));
        tableColumnDocumento.setCellValueFactory(new PropertyValueFactory<>("numeroIdentificacion"));
        tableColumnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tableColumnTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        //tableColumnNit.setCellValueFactory(new PropertyValueFactory<>("Nit"));
        //tableColumnCorreo.setCellValueFactory(new PropertyValueFactory<>("email"));
        //tableColumnFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));

        comboBoxTipoPersona.getItems().addAll(EnumTipoPersona.values());

        tableViewTablaMostrar.refresh();


    }




    public void botonRegistrar() {
        String nombre = textFieldNombre.getText();
        String primerApellido = textFieldPrimerApellido.getText();
        String segundoApellido = textFieldSegundoApellido.getText();
        String numeroId = textFieldDocumento.getText();
        String correo = textFieldCorreo.getText();
        String telefono = textFieldTelefono.getText();
        String direccion = textFieldDireccion.getText();
        String nit = textFieldNit.getText();
        LocalDate fechaN = DatePickerFechaNacimiento.getValue();

        try {
            if (comboBoxTipoPersona.getValue() == EnumTipoPersona.PERSONA_NATURAL) {
                Cliente c = new ClientePersonaNatural(nombre, primerApellido, segundoApellido, numeroId, direccion, telefono, correo, fechaN);
                INSTANCE.getAlmacen().registrarCliente(c);

                // Actualizar la lista observable y refrescar la tabla
                cliente.clear();
                cliente.addAll(INSTANCE.getAlmacen().getListClientes());
                tableViewTablaMostrar.refresh();
            } else if (comboBoxTipoPersona.getValue() == EnumTipoPersona.PERSONA_JURIDICA) {
                Cliente c = new ClientePersonaJuridica(nombre, primerApellido, segundoApellido, numeroId, direccion, telefono, nit);
                INSTANCE.getAlmacen().registrarCliente(c);

                // Actualizar la lista observable y refrescar la tabla
                cliente.clear();
                cliente.addAll(INSTANCE.getAlmacen().getListClientes());
                tableViewTablaMostrar.refresh();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir la excepción para depuración
        }
    }


    //tableColumnTipoPersona.setCellValueFactory(new PropertyValueFactory<>("tipoPersona"));


    // este metodo deshabilita los campos dependiendo el cliente seleccionado
    public void comboTipoPersona() {
        if (comboBoxTipoPersona.getValue() == EnumTipoPersona.PERSONA_NATURAL) {
            textFieldNit.setDisable(true);

        }
        if (comboBoxTipoPersona.getValue() == EnumTipoPersona.PERSONA_JURIDICA) {
            textFieldNit.setDisable(false);
            textFieldCorreo.setDisable(true);
            DatePickerFechaNacimiento.setDisable(true);

        }
    }


    public void botonEliminar() {

        String documento = textFieldDocumento.getText();
        INSTANCE.getAlmacen().eliminarClienteIdentificacion(documento);
        cliente.clear();
        cliente.addAll(INSTANCE.getAlmacen().getListClientes());
        tableViewTablaMostrar.refresh();

    }

    public void botonBuscar() {
        DatePickerFechaNacimiento.setVisible(false);
        textFieldNombre.setVisible(false);
        comboBoxTipoPersona.setVisible(false);
        textFieldDocumento.setVisible(false);
        textFieldCorreo.setVisible(false);
        textFieldDireccion.setVisible(false);
        textFieldTelefono.setVisible(false);

        String documento = textFieldDocumento.getText();
        String nombre = textFieldNombre.getText();

        if (documento.isEmpty() == false) {
            Producto producto = AlmacenInstance.INSTANCE.getAlmacen().buscarProductoCodigo(documento);
            ObservableList<Producto> mostrar = FXCollections.singletonObservableList(producto);
            tableViewTablaMostrar.refresh();
            Utils.alertaProductoBusqueda();
        } else if (nombre.isEmpty() == false) {
            Producto producto = AlmacenInstance.INSTANCE.getAlmacen().buscarProductoNombre(nombre);
            ObservableList<Producto> mostrar = FXCollections.singletonObservableList(producto);
            tableViewTablaMostrar.refresh();
            Utils.alertaProductoBusqueda();
        }
    }
    public void botonActualizar() {
    }
}

