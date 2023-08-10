package model;

public class ClientePersonaJuridica extends Cliente {
    private String nitCliente;

    public ClientePersonaJuridica(String nombreCliente, String apellidoUno, String apellidoDos, String numeroIdentificacion, String direccion, String telefono, String nitCliente) {
        super(nombreCliente, apellidoUno, apellidoDos, numeroIdentificacion, direccion, telefono);
        this.nitCliente = nitCliente;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }
}
