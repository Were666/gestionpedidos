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
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoPageableRepository;
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
	
	@MockBean
	private ProductoPageableRepository productoPageableRepository;
	
	@Before
	public void setUp() {
		
		// Configuramos un producto de pruebas...
		
		ProductoDTO producto1 = new ProductoDTO();
		
		producto1.setCodigo(100000L);
		producto1.setNombre("PRODUCTO DE TEST");
		producto1.setDescripcion("DESCRIPCION PRODUCTO DE TEST");
		producto1.setFechaAlta(new Date());
		producto1.setPrecio(100.0);
		producto1.setCategoria(CategoriaDTO.COMIDA);
		producto1.setDescatalogado(true);
		
		ProductoDTO producto2 = new ProductoDTO();
		
		producto2.setCodigo(200000L);
		producto2.setNombre("PRODUCTO DE TEST 2");
		producto2.setDescripcion("DESCRIPCION PRODUCTO DE TEST 2");
		producto2.setFechaAlta(new Date());
		producto2.setPrecio(100.0);
		producto2.setCategoria(CategoriaDTO.COMIDA);
		producto2.setDescatalogado(true);
		
		ProductoDTO producto3 = new ProductoDTO();
		
		producto3.setCodigo(300000L);
		producto3.setNombre("PRODUCTO DE TEST 3");
		producto3.setDescripcion("DESCRIPCION PRODUCTO DE TEST 3");
		producto3.setFechaAlta(new Date());
		producto3.setPrecio(100.0);
		producto3.setCategoria(CategoriaDTO.COMIDA);
		producto3.setDescatalogado(true);
		
		
		// Programamos nuestro objeto mock
		
		Mockito.when(productoRepository.getOne(100000L))
		       .thenReturn(producto1);
		
		Mockito.when(productoRepository.findAll())
				.thenReturn(Arrays.asList(producto1, producto2, producto3));
		
	
	}
	
	@Test
	public void whenValidCodigo_thenProductoShouldBeFound() throws Exception {
		String nombre = "PRODUCTO DE TEST";
		Producto encontrado = productoServices.getById(100000L);
		assertThat(encontrado.getNombre()).isEqualTo(nombre);
		assertThat(encontrado.getDescripcion()).isEqualTo("DESCRIPCION PRODUCTO DE TEST");
	}
	
	@Test
	public void whenGetAll() throws Exception {
		List<Producto> productos = this.productoServices.getAll();
		assertThat(productos.size()).isEqualTo(3);
	}
	
	@Test
	public void whenCreate() throws Exception {
		// TODO! ¿Cómo se prueba?
	}
	
	
	
}
