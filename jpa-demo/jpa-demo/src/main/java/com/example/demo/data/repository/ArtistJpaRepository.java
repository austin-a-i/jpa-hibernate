package com.example.demo.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entity.Artist;

@Repository
public interface ArtistJpaRepository extends JpaRepository<Artist, Long> {

}
