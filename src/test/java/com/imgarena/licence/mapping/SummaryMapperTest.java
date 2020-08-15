package com.imgarena.licence.mapping;

import com.imgarena.licence.domain.Match;
import com.imgarena.licence.domain.SummaryType;
import com.imgarena.licence.time.TimeProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Month;

import static java.time.LocalDateTime.of;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SummaryMapperTest {

    @InjectMocks
    private SummaryMapper summaryMapper;

    @Mock
    private TimeProvider timeProvider;

    private Match match;

    private static final int MATCH_ID = 1234;
    private static final String PLAYER1 = "Player1";
    private static final String PLAYER2 = "Player2";

    @BeforeEach
    public void init() {
        match = Match.builder()
                .matchId(MATCH_ID)
                .startDate(of(2020, Month.AUGUST, 15, 20, 00))
                .playerA(PLAYER1)
                .playerB(PLAYER2)
                .build();
    }

    @Test
    public void shortDescription() {
        String summary = summaryMapper.map(SummaryType.AvB, match);
        Assertions.assertThat(summary).isEqualTo(PLAYER1 + " vs " + PLAYER2);
    }

    @Test
    public void detailedDescriptionBeforeStartDate() {
        when(timeProvider.getCurrentTime()).thenReturn(of(2020, Month.AUGUST, 15, 19, 30));
        String summary = summaryMapper.map(SummaryType.AvBTime, match);
        Assertions.assertThat(summary).isEqualTo(PLAYER1 + " vs " + PLAYER2 + ", starts in: 30 minutes");
    }

    @Test
    public void detailedDescriptionAfterStartDate() {
        when(timeProvider.getCurrentTime()).thenReturn(of(2020, Month.AUGUST, 15, 20, 30));
        String summary = summaryMapper.map(SummaryType.AvBTime, match);
        Assertions.assertThat(summary).isEqualTo(PLAYER1 + " vs " + PLAYER2 + ", started 30 minutes ago");
    }
}