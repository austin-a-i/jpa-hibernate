package com.example.demo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entity.Song;

@Repository
public interface SongJpaRepository extends JpaRepository<Song, Long> {
	
	public List<Song> findSongByArtistId(long artistId);
}
