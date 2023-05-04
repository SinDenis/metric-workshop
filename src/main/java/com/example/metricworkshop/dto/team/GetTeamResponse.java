package com.example.metricworkshop.dto.team;

public record GetTeamResponse(
    Long id,
    String name,
    String country,
    int rating
) {

}
