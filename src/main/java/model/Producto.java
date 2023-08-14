package model;

public class Producto {
    private final String codigoProducto;
    private final String nombreProducto;
    private String descripcionProducto;
    private float valorUnitario;
    private int cantidadExistente;

    protected Producto(String codigoProducto, String nombreProducto, String descripcionProducto, float valorUnitario, int cantidadExistente) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.valorUnitario = valorUnitario;
        this.cantidadExistente = cantidadExistente;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(int cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoProducto='" + codigoProducto + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", cantidadExistente=" + cantidadExistente +
                '}';
    }
}
