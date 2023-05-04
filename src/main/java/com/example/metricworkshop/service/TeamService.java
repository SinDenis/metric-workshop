package com.example.metricworkshop.service;

import com.example.metricworkshop.dto.team.GetEnrichedTeamResponse;
import com.example.metricworkshop.entity.Player;
import com.example.metricworkshop.entity.Team;
import com.example.metricworkshop.mapper.GetEnrichedTeamResponseMapper;
import com.example.metricworkshop.repository.PlayerRepository;
import com.example.metricworkshop.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final GetEnrichedTeamResponseMapper getEnrichedTeamResponseMapper;

    @Transactional
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Transactional
    public Team addPlayer(long teamId, long playerId) {
        Player player = playerRepository.findById(playerId)
            .orElseThrow(() -> new RuntimeException("Not found player by id = " + playerId));
        Team team = teamRepository.findById(teamId)
            .orElseThrow(() -> new RuntimeException("Not found team by id = " + teamId));
        team.getPlayers().add(player);
        player.setTeam(team);
        return teamRepository.save(team);
    }

    @Transactional(readOnly = true)
    public List<GetEnrichedTeamResponse> getAllTeams() {
        return getEnrichedTeamResponseMapper.map(teamRepository.findAll());
    }

    @Transactional
    public Team calculateRating(Long id, int value) {
        Team team = teamRepository.findByIdWithPessimisticLock(id)
            .orElseThrow(() -> new RuntimeException("Not found team by id = " + id));
        int multiplier = getMultiplier(team.getRating());
        team.setRating(team.getRating() + multiplier * value);
        return teamRepository.save(team);
    }

    private int getMultiplier(int currentRating) {
        if (currentRating < 0 || currentRating > 2000) {
            return 1;
        }
        return 2;
    }
}
