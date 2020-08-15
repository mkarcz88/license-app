package com.imgarena.licence.mapping;

import com.imgarena.licence.domain.Match;
import com.imgarena.licence.domain.SummaryType;
import com.imgarena.licence.time.TimeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.imgarena.licence.domain.SummaryType.AvBTime;
import static java.lang.Math.abs;

@Component
public class SummaryMapper {

    @Autowired
    public TimeProvider timeProvider;

    public String map(SummaryType summaryType, Match match) {
        if (AvBTime.equals(summaryType)) {
            return createDetailedDescription(match);
        } else {
            return createShortDescription(match);
        }
    }

    private String createShortDescription(Match match) {
        return match.getPlayerA() + " vs " + match.getPlayerB();
    }

    private String createDetailedDescription(Match match) {
        LocalDateTime startTime = match.getStartDate();
        LocalDateTime now = timeProvider.getCurrentTime();
        long minutes = ChronoUnit.MINUTES.between(startTime, now);

        if (minutes < 0) {
            return createShortDescription(match) + ", starts in: " + abs(minutes) + " minutes";
        } else {
            return createShortDescription(match) + ", started " + minutes + " minutes ago";
        }
    }
}
