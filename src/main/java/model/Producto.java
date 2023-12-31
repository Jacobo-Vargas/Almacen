package model;

import controller.Utils;

public class Producto {


    private  String codigoProducto;
    private  String nombreProducto;
    private String descripcionProducto;
    private float valorUnitario;
    private int cantidadExistente;

    protected Producto(String codigoProducto, String nombreProducto, String descripcionProducto, float valorUnitario, int cantidadExistente) {
        if(codigoProducto.isEmpty()){
            Utils.alertaProductoError();
        }else{
            this.codigoProducto = codigoProducto;
        }
        if(nombreProducto.isEmpty()){
            Utils.alertaProductoError();
        }else{
            this.nombreProducto = nombreProducto;
        }
        if(descripcionProducto.isEmpty()){
            Utils.alertaProductoError();
        }else{
            this.descripcionProducto = descripcionProducto;
        }
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
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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
