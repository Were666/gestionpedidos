package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;
import com.pgrsoft.gestionpedidos.backend.business.services.CamareroServices;
import com.pgrsoft.gestionpedidos.backend.presentation.model.CamareroVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.CamareroPresentationServices;

@Service
public class CamareroPresentationServicesImpl implements CamareroPresentationServices {

	@Autowired
	private CamareroServices camareroServices;
	
//	@Qualifier(value="camareroConverter")
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public CamareroVO getById(final Long id) throws Exception {
			
		CamareroVO camareroVO = null;
		
		try {
			final Camarero camarero = camareroServices.getById(id);
			camareroVO = this.dozerBeanMapper.map(camarero, CamareroVO.class);
		} catch (Exception e) {
		//  logger.error("fdfd");
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return camareroVO;
	}

//	@SuppressWarnings("unchecked")
	@Override
	public List<CamareroVO> getAll() throws Exception {
		
		List<CamareroVO> camarerosVO = new ArrayList<CamareroVO>();
		
		try {
			final List<Camarero> camareros = camareroServices.getAll();
			
			System.out.println("camareros: " + camareros);
					
			for (Camarero camarero: camareros) {
				System.out.println("camarero: " + camarero);
				CamareroVO camareroVO = this.dozerBeanMapper.map(camarero,CamareroVO.class);
				System.out.println(camareroVO);
				camarerosVO.add(camareroVO);
			}
			
			System.out.println("camarerosVO: " + camarerosVO);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return camarerosVO;
	}

	@Override
	public CamareroVO create(final CamareroVO newCamareroVO) throws Exception {
		
		CamareroVO camareroVO = null;
		
		try {
			final Camarero newCamarero = dozerBeanMapper.map(newCamareroVO, Camarero.class);
			final Camarero createdCamarero = camareroServices.create(newCamarero);
			camareroVO = dozerBeanMapper.map(createdCamarero, CamareroVO.class);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return camareroVO;
	}

}
