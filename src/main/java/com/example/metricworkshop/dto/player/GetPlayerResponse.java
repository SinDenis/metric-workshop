package com.example.metricworkshop.dto.player;

import lombok.Builder;

import java.time.Instant;

@Builder
public record GetPlayerResponse(
    Long id,
    String name,
    Instant birthDate,
    String team
) {

}
