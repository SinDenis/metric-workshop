package com.example.metricworkshop.mapper;

import com.example.metricworkshop.config.MapStructConfig;
import com.example.metricworkshop.dto.team.CreateTeamRequest;
import com.example.metricworkshop.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface CreateTeamRequestMapper {

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "tournaments", ignore = true)
    @Mapping(target = "players", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    Team map(CreateTeamRequest request);

}
