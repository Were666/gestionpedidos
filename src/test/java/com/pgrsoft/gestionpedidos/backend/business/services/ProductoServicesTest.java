package com.pgrsoft.gestionpedidos.backend.business.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.pgrsoft.gestionpedidos.backend.business.model.Producto;
import com.pgrsoft.gestionpedidos.backend.business.services.impl.ProductoServicesImpl;
import com.pgrsoft.gestionpedidos.backend.integration.model.CategoriaDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class ProductoServicesTest {

	@TestConfiguration
	static class ProductoSericeTestContextConfiguration{
		
		@Bean
		public ProductoServices productoService() {
			return new ProductoServicesImpl();		// Implementación que vamos a testear
		}	
		
		@Bean
		public DozerBeanMapper getMapper() {
			List<String> mappingFiles = Arrays.asList("dozer-configration-mapping.xml");
	        DozerBeanMapper dozerBean = new DozerBeanMapper();
	        dozerBean.setMappingFiles(mappingFiles);
	        return dozerBean;
		}
	}
	
	
	@Autowired
	private ProductoServices productoServices;
	
	@MockBean
	private ProductoRepository productoRepository;
	
	@Before
	public void setUp() {
		
		// Configuramos un producto de pruebas...
		
		ProductoDTO producto = new ProductoDTO();
		
		producto.setCodigo(100000L);
		producto.setNombre("PRODUCTO DE TEST");
		producto.setDescripcion("DESCRIPCION PRODUCTO DE TEST");
		producto.setFechaAlta(new Date());
		producto.setPrecio(100.0);
		producto.setCategoria(CategoriaDTO.AGUA);
		producto.setDescatalogado(true);
		
		Mockito.when(productoRepository.getOne(100000L))
		       .thenReturn(producto);
		
	}
	
	@Test
	public void whenValidCodigo_thenProductoShouldBeFound() throws Exception {
		String nombre = "PRODUCTO DE TEST";
		Producto encontrado = productoServices.getById(100000L);
		assertThat(encontrado.getNombre()).isEqualTo(nombre);
		assertThat(encontrado.getDescripcion()).isEqualTo("DESCRIPCION PRODUCTO DE TEST");
	}
	
}
