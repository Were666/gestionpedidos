package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppErrorController implements ErrorController {

	@RequestMapping("/error")
    public ErrorDTO handleError(HttpServletRequest request) {
		
		Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		ErrorDTO errorDTO = new ErrorDTO();
		
		if (statusCode != null) {
			
			errorDTO.setCodigo(statusCode);
			
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	
	        	errorDTO.setMensaje("Recurso no encontrado...");
	        
	        	return errorDTO;
	        }
	        
	        if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	
	        	errorDTO.setMensaje(":-( error en el servidor. Estaría bien saber qué...");
	        	
	        	return errorDTO;
	        
	        }
	    }
		
		return errorDTO;
	
    }
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	/**
	 * 
	 * Clase interna que modeliza un JSON de respuesta de error.
	 * 
	 * @author Jordi Alemany
	 *
	 */
	
	class ErrorDTO {
		
		private int codigo;
		private String mensaje;
		
		public ErrorDTO() {
			
		}
		
		public ErrorDTO(int codigo, String mensaje) {
			this.codigo = codigo;
			this.mensaje = mensaje;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getMensaje() {
			return mensaje;
		}

		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}
		
	}

}
