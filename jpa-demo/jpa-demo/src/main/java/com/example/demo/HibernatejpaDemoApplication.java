package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernatejpaDemoApplication {

	// private Logger log = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(HibernatejpaDemoApplication.class, args);
	}
	
}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * 
	 * //audienceRepository.saveAudienceWithGenre();
	 * 
	 * Songs song = repository.findById(1001);
	 * 
	 * log.info("Song 1001 -. {}", song); //repository.deleteById(1001);
	 * repository.saveSong(new Songs("Fire And Flood"));
	 * 
	 * //repository.playWithEntityManager(); //artistRepository.addSongsOfArtist();
	 * 
	 * 
	 * Artist And Song List<Song> songs = new ArrayList<>(); songs.add( new
	 * Song("4.5", "Anchor")); songs.add( new Song("5", "Opalene"));
	 * 
	 * artistRepository.addSongsOfArtist(1003, songs);
	 * 
	 * 
	 * 
	 * Artist And Audience artistRepository.addArtistAndAudience();
	 * artistRepository.addArtistAndAudience(new Artist("Martin Garrix"), new
	 * Audience("EDM"));
	 * 
	 * 
	 * List<Artist> artist = new ArrayList<Artist>(); artist.add(new
	 * Artist("Ben Platt")); artistRepository.retrieveArtistsWithGenre(4001,
	 * artist);
	 * 
	 * }
	 */


