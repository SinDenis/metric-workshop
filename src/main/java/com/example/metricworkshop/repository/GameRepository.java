package com.example.metricworkshop.repository;

import com.example.metricworkshop.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
