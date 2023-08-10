package model;

public class Cliente {
    private String nombreCliente;
    private String apellidoUno;
    private String apellidoDos;
    private final String numeroIdentificacion;
    private String direccion;
    private String telefono;

    public Cliente(String nombreCliente, String apellidoUno, String apellidoDos, String numeroIdentificacion, String direccion, String telefono) {
        this.nombreCliente = nombreCliente;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.numeroIdentificacion = numeroIdentificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
