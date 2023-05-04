package com.example.metricworkshop.controller;

import com.example.metricworkshop.dto.team.AddTeamPlayerRequest;
import com.example.metricworkshop.dto.team.CreateTeamRequest;
import com.example.metricworkshop.dto.team.GetEnrichedTeamResponse;
import com.example.metricworkshop.dto.team.GetTeamResponse;
import com.example.metricworkshop.entity.Team;
import com.example.metricworkshop.mapper.CreateTeamRequestMapper;
import com.example.metricworkshop.mapper.GetTeamResponseMapper;
import com.example.metricworkshop.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;
    private final CreateTeamRequestMapper createTeamRequestMapper;
    private final GetTeamResponseMapper getTeamResponseMapper;

    @PostMapping
    public GetTeamResponse create(@RequestBody CreateTeamRequest request) {
        Team team = createTeamRequestMapper.map(request);
        return getTeamResponseMapper.map(teamService.save(team));
    }

    @PostMapping("/{id}/players")
    public GetTeamResponse addPlayer(@PathVariable("id") Long teamId, @RequestBody AddTeamPlayerRequest request) {
        return getTeamResponseMapper.map(teamService.addPlayer(teamId, request.playerId()));
    }

    @GetMapping
    public List<GetEnrichedTeamResponse> getTeams() {
        return teamService.getAllTeams();
    }

    @PutMapping("/{id}/rating")
    public GetTeamResponse calculateRating(@PathVariable("id") Long id, @RequestParam("value") int value) {
        return getTeamResponseMapper.map(teamService.calculateRating(id, value));
    }

}
