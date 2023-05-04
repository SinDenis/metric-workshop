package com.example.metricworkshop.metric;

import io.micrometer.core.instrument.Metrics;

public class TeamProcessorMetric {

    public static void incrementTeamCount() {
        Metrics.counter("workshop_team_process").increment();
    }

}
