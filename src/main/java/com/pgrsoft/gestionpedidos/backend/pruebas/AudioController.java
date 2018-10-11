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

	@RequestMapping("/sonido")
	public String play() {
		
		
		try {
			Clip clip = AudioSystem.getClip();
			File file = new ClassPathResource("space.wav").getFile();
			
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			
			clip.open(ais);
			clip.start();
			
		} catch (LineUnavailableException e) {
			
			e.printStackTrace();
			
		} catch (UnsupportedAudioFileException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return "sonido";
	}
	
}
