package com.example.metricworkshop.repository;

import com.example.metricworkshop.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

}
