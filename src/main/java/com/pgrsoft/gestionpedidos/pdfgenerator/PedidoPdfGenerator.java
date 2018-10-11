package com.pgrsoft.gestionpedidos.pdfgenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.pgrsoft.gestionpedidos.backend.presentation.model.LineaPedidoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.model.PedidoVO;

@Component
public class PedidoPdfGenerator {

	public void generarPDFPedido(PedidoVO pedidoVO) {
		
		Document document = new Document();
		
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pedidos_pdf/pedido_" + pedidoVO.getId() + ".pdf"));
			document.open();
			document.add(new Paragraph("Número de pedido: " + pedidoVO.getId()));
			document.add(new Paragraph("Camarero: " + pedidoVO.getCamarero().getNombre()));
			document.add(new Paragraph("Mesa: " + pedidoVO.getMesa()));
			
			
			PdfPTable table = new PdfPTable(5); // 5 columns.
			table.setWidthPercentage(100); //Width 100%
			table.setSpacingBefore(10f); //Space before table
			table.setSpacingAfter(10f); //Space after table
			
			//Set Column widths
	        float[] columnWidths = {1f, 1f, 1f, 1f, 1f};
	        table.setWidths(columnWidths);
	        
	        PdfPCell cell1 = new PdfPCell(new Paragraph("Código"));
	        PdfPCell cell2 = new PdfPCell(new Paragraph("Producto"));
	        PdfPCell cell3 = new PdfPCell(new Paragraph("Cantidad"));
	        PdfPCell cell4 = new PdfPCell(new Paragraph("Precio"));
	        PdfPCell cell5 = new PdfPCell(new Paragraph("Total"));
	        
	        cell1.setPaddingLeft(10);
	        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        cell1.setBorderColor(BaseColor.LIGHT_GRAY);
	        cell2.setBorderColor(BaseColor.LIGHT_GRAY);
	        cell3.setBorderColor(BaseColor.LIGHT_GRAY);
	        cell4.setBorderColor(BaseColor.LIGHT_GRAY);
	        cell5.setBorderColor(BaseColor.LIGHT_GRAY);
	        
	        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        
	        table.addCell(cell1);
	        table.addCell(cell2);
	        table.addCell(cell3);
	        table.addCell(cell4);
	        table.addCell(cell5);
	        
	        for(LineaPedidoVO lp: pedidoVO.getLineasPedido()) {
	        	PdfPCell c1 = new PdfPCell(new Paragraph(String.valueOf(lp.getProducto().getCodigo())));
	        	PdfPCell c2 = new PdfPCell(new Paragraph(lp.getProducto().getNombre()));
	        	PdfPCell c3 = new PdfPCell(new Paragraph(String.valueOf(lp.getCantidad())));
	        	PdfPCell c4 = new PdfPCell(new Paragraph(String.valueOf(lp.getPrecio())));
	        	PdfPCell c5 = new PdfPCell(new Paragraph(String.valueOf(lp.getCantidad() * lp.getPrecio())));
	        	c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        	c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
	        	c3.setHorizontalAlignment(Element.ALIGN_RIGHT);
	        	c4.setHorizontalAlignment(Element.ALIGN_RIGHT);
	        	c5.setHorizontalAlignment(Element.ALIGN_RIGHT);
	        	table.addCell(c1);
	        	table.addCell(c2);
	        	table.addCell(c3);
	        	table.addCell(c4);
	        	table.addCell(c5);
	        }
	       
	        document.add(table);
	       	
			//Set attributes here
		    document.addAuthor("Honorio Martín Salvador");
		    document.addCreationDate();
		    document.addCreator("PGRSOFT");
		    document.addTitle("Pedido " + pedidoVO.getId());
		    document.addSubject("Ejemplo de creación de pedido en PDF.");
			
			document.close();
			writer.close();
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

}
