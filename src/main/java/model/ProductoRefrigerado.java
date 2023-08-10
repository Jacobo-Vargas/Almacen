package model;

public class ProductoRefrigerado extends Producto{

    private final String codigoAprobacion;
    private final float temperaturaRecomendada;

    public ProductoRefrigerado(String codigoProducto, String nombreProducto, String descripcionProducto, float valorUnitario, int cantidadExistente, String codigoAprobacion, float temperaturaRecomendada) {
        super(codigoProducto, nombreProducto, descripcionProducto, valorUnitario, cantidadExistente);
        this.codigoAprobacion = codigoAprobacion;
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    public String getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public float getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }
}
