package com.pgrsoft.gestionpedidos.backend.pruebas;

import java.io.File;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.presentation.model.PedidoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.PedidoPresentationServices;

@RestController
public class AudioController {
	
	@Autowired
	private PedidoPresentationServices pedidoServices;

	@RequestMapping("/sintetizador")
	public String sintetizarVoz() {
		
	
		
		return "sintetizador de voz";
	}

	@RequestMapping("/orders")
	public List<PedidoVO> play() {
		
		List<PedidoVO> pedidos = null;
		
		try {
			
			pedidos = this.pedidoServices.getAll();
			
			Clip clip = AudioSystem.getClip();
			File file = new ClassPathResource("space.wav").getFile();
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			
			clip.open(ais);
			
			clip.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} 
	
		return pedidos;
	}
	
}
