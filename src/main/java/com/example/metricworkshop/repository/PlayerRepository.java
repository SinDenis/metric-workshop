package com.example.metricworkshop.repository;

import com.example.metricworkshop.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
