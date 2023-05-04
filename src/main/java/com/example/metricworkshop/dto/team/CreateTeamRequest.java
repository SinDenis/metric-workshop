package com.example.metricworkshop.dto.team;

public record CreateTeamRequest(
    String name,
    String country,
    int rating
) {

}
