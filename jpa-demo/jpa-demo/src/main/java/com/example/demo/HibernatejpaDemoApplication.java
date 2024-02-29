package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Artist;
import com.example.demo.repository.ArtistRepository;

@SpringBootApplication
public class HibernatejpaDemoApplication implements CommandLineRunner {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArtistRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HibernatejpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Songs song = repository.findById(1001);
		 * 
		 * log.info("Song 1001 -. {}", song); //repository.deleteById(1001);
		 * repository.saveSong(new Songs("Fire And Flood"));
		 */
		repository.playWithEntityManager();
	}
}
