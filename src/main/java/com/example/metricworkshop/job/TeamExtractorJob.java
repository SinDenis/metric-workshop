package com.example.metricworkshop.job;

import com.example.metricworkshop.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TeamExtractorJob {

    private final TeamRepository teamRepository;

    @Scheduled(fixedRate = 5000)
    public void process() {
        log.info("Started process games job");
        teamRepository.findAll()
            .forEach(System.out::println);
    }

}
