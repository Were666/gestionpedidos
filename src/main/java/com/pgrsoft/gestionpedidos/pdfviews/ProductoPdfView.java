package com.pgrsoft.gestionpedidos.pdfviews;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import com.pgrsoft.gestionpedidos.backend.presentation.model.ProductoVO;

@Component("productoView")
public class ProductoPdfView extends  AbstractView {

//	private SimpleDateFormat sdfF = new SimpleDateFormat("dd/MM/yyyy");


	private DecimalFormat formatoImporte = new DecimalFormat("0.00");
	private DecimalFormat formatoCodigo = new DecimalFormat("000000");
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//response.setHeader("?");
		
		@SuppressWarnings("unchecked")
		List<ProductoVO> productos = (List<ProductoVO>) model.get("productos");
		
		PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
		PdfDocument pdf = new PdfDocument(pdfWriter);
		
		pdf.setDefaultPageSize(PageSize.A4.rotate());
		
		Document pdfDocument = new Document(pdf);
		
		
		//title
		Paragraph title = new Paragraph("Listado de Productos");
		title.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
	    title.setFontSize(18f);
	    title.setMarginBottom(30f);
	    pdfDocument.add(title);
	    
	
	    Table table = new Table(new float[]{5f,40f, 5f,5f,5f});
	    table
	    	.setWidth(UnitValue.createPercentValue(100))
	    	.setTextAlignment(TextAlignment.CENTER);
	    	
	    Cell h1 = new Cell().add(new Paragraph("Código"));
	    Cell h2 = new Cell().add(new Paragraph("Producto"));
	    Cell h4 = new Cell().add(new Paragraph("Descripción"));
	    Cell h5 = new Cell().add(new Paragraph("Precio"));
	    Cell h6 = new Cell().add(new Paragraph("Descatalogado"));
	    
	    h1.setFontColor(Color.WHITE);
	    h2.setFontColor(Color.WHITE);
	    h4.setFontColor(Color.WHITE);
	    h5.setFontColor(Color.WHITE);
	    h6.setFontColor(Color.WHITE);
	    
	    h1.setBackgroundColor(Color.BLACK).setTextAlignment(TextAlignment.CENTER);
	    h2.setBackgroundColor(Color.BLACK).setTextAlignment(TextAlignment.CENTER);
	    h4.setBackgroundColor(Color.BLACK).setTextAlignment(TextAlignment.CENTER);
	    h5.setBackgroundColor(Color.BLACK).setTextAlignment(TextAlignment.CENTER);
	    h6.setBackgroundColor(Color.BLACK).setTextAlignment(TextAlignment.CENTER);
	    
	    table.addHeaderCell(h1);
	    table.addHeaderCell(h2);
	    table.addHeaderCell(h4);
	    table.addHeaderCell(h5);
	    table.addHeaderCell(h6);
	   
	    for(ProductoVO producto: productos) {
	    	Cell cCodigo = new Cell().add(new Paragraph(formatoCodigo.format(producto.getCodigo())));
	    	Cell cProducto = new Cell().add(new Paragraph(producto.getNombre()));
	    	Cell cCantidad = new Cell().add(new Paragraph(producto.getDescripcion()));
	    	Cell cPrecio = new Cell().add(new Paragraph(formatoImporte.format(producto.getPrecio()) + " €"));
	    	Cell cTotal = new Cell().add(new Paragraph(String.valueOf(producto.isDescatalogado())));
	    	
	    	cCodigo.setTextAlignment(TextAlignment.CENTER);
	    	cProducto.setTextAlignment(TextAlignment.LEFT);
	    	
	    	table.addCell(cCodigo);
	    	table.addCell(cProducto);
	    	table.addCell(cCantidad).setTextAlignment(TextAlignment.RIGHT);
	    	table.addCell(cPrecio).setTextAlignment(TextAlignment.RIGHT);
	    	table.addCell(cTotal).setTextAlignment(TextAlignment.RIGHT);
	    
	    }
	    
	    pdfDocument.add(table);
	    pdfDocument.close();
	 	
	}
	
}