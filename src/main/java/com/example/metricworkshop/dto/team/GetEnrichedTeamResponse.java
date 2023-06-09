package com.example.metricworkshop.dto.team;

import java.util.List;

public record GetEnrichedTeamResponse(
    Long id,
    String name,
    String country,
    int rating,
    List<String> players
) {

}
