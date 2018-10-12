package com.pgrsoft.gestionpedidos.pdfviews;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.pgrsoft.gestionpedidos.backend.presentation.model.LineaPedidoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.model.PedidoVO;

@Component("pedidoView")
public class PedidoPdfView extends  AbstractView {

	private SimpleDateFormat sdfF = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
	private NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.GERMAN);
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//response.setHeader("", "");
		
		PedidoVO pedido = (PedidoVO) model.get("pedido");
		
		PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
		PdfDocument pdf = new PdfDocument(pdfWriter);
		Document pdfDocument = new Document(pdf);
		
		//title
		Paragraph title = new Paragraph("Pedido " + pedido.getId());
		title.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
	    title.setFontSize(18f);
	    //title.setItalic();
	    pdfDocument.add(title);
	    
	    //content
	    Paragraph fecha = new Paragraph("Fecha: " + sdfF.format(pedido.getFecha()));
	    Paragraph hora = new Paragraph("Hora: " + sdfH.format(pedido.getFecha()));
	    Paragraph camarero = new Paragraph("Camarero: " + pedido.getCamarero().getNombre());
	    Paragraph mesa = new Paragraph("Mesa: " + pedido.getMesa());
	    
	    pdfDocument.add(fecha);
	    pdfDocument.add(hora);
	    pdfDocument.add(camarero);
	    pdfDocument.add(mesa);
	    
	   
	    Table table = new Table(new float[]{5f,20f,20f, 5f,5f,5f});
	    table
	    	.setWidth(UnitValue.createPercentValue(100))
	    	.setTextAlignment(TextAlignment.CENTER);
	    	
	    
	    Cell h1 = new Cell().add(new Paragraph("Código"));
	    Cell h2 = new Cell().add(new Paragraph("Producto"));
	    Cell h3 = new Cell().add(new Paragraph("Descripción"));
	    Cell h4 = new Cell().add(new Paragraph("Cantidad"));
	    Cell h5 = new Cell().add(new Paragraph("Precio"));
	    Cell h6 = new Cell().add(new Paragraph("Total"));
	    
//	    h1.setFontColor(Color.WHITE);
//	    h2.setFontColor(Color.WHITE);
//	    h3.setFontColor(Color.WHITE);
//	    h4.setFontColor(Color.WHITE);
//	    h5.setFontColor(Color.WHITE);
//	    h6.setFontColor(Color.WHITE);
	    
	    h1.setBackgroundColor(Color.LIGHT_GRAY);
	    h2.setBackgroundColor(Color.LIGHT_GRAY);
	    h3.setBackgroundColor(Color.LIGHT_GRAY);
	    h4.setBackgroundColor(Color.LIGHT_GRAY);
	    h5.setBackgroundColor(Color.LIGHT_GRAY);
	    h6.setBackgroundColor(Color.LIGHT_GRAY);
	    
	    table.addHeaderCell(h1);
	    table.addHeaderCell(h2);
	    table.addHeaderCell(h3);
	    table.addHeaderCell(h4);
	    table.addHeaderCell(h5);
	    table.addHeaderCell(h6);
	   
	    for(LineaPedidoVO lp: pedido.getLineasPedido()) {
	    	Cell cCodigo = new Cell().add(new Paragraph(String.valueOf(lp.getProducto().getCodigo())));
	    	Cell cProducto = new Cell().add(new Paragraph(lp.getProducto().getNombre()));
	    	Cell cDescripcion = new Cell().add(new Paragraph(lp.getProducto().getDescripcion()));
	    	Cell cCantidad = new Cell().add(new Paragraph(String.valueOf(lp.getCantidad())));
	    	Cell cPrecio = new Cell().add(new Paragraph(numberFormat.format(lp.getPrecio())));
	    	Cell cTotal = new Cell().add(new Paragraph(numberFormat.format(lp.getCantidad() * lp.getPrecio())));
	    	
	    	cProducto.setTextAlignment(TextAlignment.LEFT);
	    	cDescripcion.setTextAlignment(TextAlignment.LEFT);
	    	
	    	table.addCell(cCodigo);
	    	table.addCell(cProducto);
	    	table.addCell(cDescripcion);
	    	table.addCell(cCantidad);
	    	table.addCell(cPrecio);
	    	table.addCell(cTotal);
	    
	    }
	    
	    pdfDocument.add(table);
	    pdfDocument.close();
	 	
	}
	
}