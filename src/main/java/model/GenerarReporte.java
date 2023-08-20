package model;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import model.DetalleVenta;
import model.Venta;

import java.io.IOException;

import static java.lang.String.valueOf;

public class GenerarReporte {

    public static void generarPDFVenta(Venta venta) throws IOException {

        String nombreArchivo = "Venta_" + venta.getCodigo() + ".pdf";

        // Agrega la ruta absoluta en la siguiente línea
        String rutaEscritorio = System.getenv("HOME") + "/Escritorio/";
        String rutaArchivo = rutaEscritorio + nombreArchivo;

        try (PdfWriter writer = new PdfWriter(rutaArchivo);

             PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf)) {

            // Agregar contenido al PDF
            document.add(new Paragraph("**************************************************************************************"));
            document.add(new Paragraph("**                             Información de la Venta                                               **"));
            document.add(new Paragraph("**************************************************************************************"));
            document.add(new Paragraph("Código: " + venta.getCodigo()));
            document.add(new Paragraph("Cliente: " + venta.getCliente().getNombreCliente()+" "+ venta.getCliente().getApellidoUno()+" "+venta.getCliente().getApellidoDos()));
            document.add(new Paragraph("Cedula: "+ venta.getCliente().getNumeroIdentificacion()));
            document.add(new Paragraph("Telefono: "+ venta.getCliente().getTelefono() ));
            document.add(new Paragraph("Direccion: "+ venta.getCliente().getDireccion()));
            document.add(new Paragraph("**************************************************************************************"));


            // Agregar más información según necesites

            // Crear una tabla para mostrar los detalles de la venta
            Table table = new Table(4); // 4 columnas para cantidad, coddigo nobre de producto y subtotal
            table.addCell("Cantidad");
            table.addCell("Codigo producto   ");
            table.addCell("Nombre del producto");
            table.addCell("Subtotal   ");
            table.addFooterCell(valueOf("total a pagar: "+ venta.calcularTotal()));

            for (DetalleVenta detalle : venta.getDetalleVenta()) {
                table.addCell(valueOf(detalle.getCantidadProductos()));
                table.addCell(detalle.getProductoVendido());
                table.addCell(detalle.obtenerNombreProducto());
                table.addCell(valueOf(detalle.getSubtotal()));
            }


            document.add(table);
        }
    }
}

