package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Cliente;
import com.pgrsoft.gestionpedidos.backend.business.services.ClienteServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.ClienteDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ClienteRepository;

@Service
public class ClienteServicesImpl implements ClienteServices {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public Cliente getById(Long id) {
		final ClienteDTO clienteDTO = this.clienteRepository.getOne(id);
		final Cliente cliente = this.dozerBeanMapper.map(clienteDTO, Cliente.class);
		
		return cliente;
	}

	@Override
	public List<Cliente> getAll() {
		
		final List<ClienteDTO> clientesDTO = this.clienteRepository.findAll();
		
		return clientesDTO.stream()
			.map(x -> this.dozerBeanMapper.map(x, Cliente.class))
			.collect(Collectors.toList());
	
	}

	@Override
	public Cliente create(final Cliente cliente) {
		
		final ClienteDTO newClienteDTO = this.dozerBeanMapper.map(cliente, ClienteDTO.class);
		
		final ClienteDTO createdClienteDTO = this.clienteRepository.save(newClienteDTO);
		
		final Cliente createdCliente = this.dozerBeanMapper.map(createdClienteDTO, Cliente.class);
		
		return createdCliente;
	}

}
