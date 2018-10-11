package com.pgrsoft.gestionpedidos.backend.pruebas;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AudioController {

	@RequestMapping("/david")
	public String play() {
		
		String respuesta = "hola";
		
		try {
			Clip clip = AudioSystem.getClip();
			File file = new ClassPathResource("space.wav").getFile();
			
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			
			clip.open(ais);
			clip.start();
			
		} catch (LineUnavailableException e) {
			
			respuesta = e.getMessage();
			
		} catch (UnsupportedAudioFileException e) {
			
			respuesta = e.getMessage();
			
		} catch (IOException e) {
			
			respuesta = e.getMessage();
		}
		
		
		return respuesta;
	}
	
}
