package com.example.metricworkshop.mapper;

import com.example.metricworkshop.config.MapStructConfig;
import com.example.metricworkshop.dto.team.GetTeamResponse;
import com.example.metricworkshop.entity.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface GetTeamResponseMapper {

    GetTeamResponse map(Team team);

    List<GetTeamResponse> map(List<Team> teams);

}
