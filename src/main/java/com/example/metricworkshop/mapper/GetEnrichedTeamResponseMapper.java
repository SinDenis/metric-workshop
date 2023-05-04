package com.example.metricworkshop.mapper;


import com.example.metricworkshop.config.MapStructConfig;
import com.example.metricworkshop.dto.team.GetEnrichedTeamResponse;
import com.example.metricworkshop.entity.Player;
import com.example.metricworkshop.entity.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface GetEnrichedTeamResponseMapper {

    List<GetEnrichedTeamResponse> map(List<Team> teams);

    GetEnrichedTeamResponse map(Team team);

    default String map(Player player) {
        return player.getName();
    }

}
