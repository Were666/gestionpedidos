package com.pgrsoft.gestionpedidos.pdfviews;

import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.pgrsoft.gestionpedidos.backend.presentation.model.PedidoVO;

@Component("pedidoView")
public class PedidoPdfView extends  AbstractView {

	private SimpleDateFormat sdfF = new SimpleDateFormat("dd/MM/yyyy");
//	private SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
	
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
	    title.setItalic();
	    pdfDocument.add(title);
	    
	    
	    //date
	    Paragraph date = new Paragraph(sdfF.format(pedido.getFecha()));
	    date.setFontSize(16f);
	    pdfDocument.add(date);
	    
	    
	    //content
	    Paragraph content = new Paragraph("Camarero: " + pedido.getCamarero().getNombre());
	    pdfDocument.add(content);

	    pdfDocument.close();
	 	
	}


	
}