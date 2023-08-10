package model;

import java.time.LocalDate;

public class ClientePersonaNatural extends Cliente{

    private String email;
    private final LocalDate fechaNacimiento;

    public ClientePersonaNatural(String nombreCliente, String apellidoUno, String apellidoDos, String numeroIdentificacion, String direccion, String telefono, String email, LocalDate fechaNacimiento) {
        super(nombreCliente, apellidoUno, apellidoDos, numeroIdentificacion, direccion, telefono);
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

}
