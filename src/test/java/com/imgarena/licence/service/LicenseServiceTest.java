package com.imgarena.licence.service;

import com.imgarena.licence.dao.MatchRepository;
import com.imgarena.licence.domain.Match;
import com.imgarena.licence.domain.GetMatchesCommand;
import com.imgarena.licence.domain.SummaryType;
import com.imgarena.licence.mapping.SummaryMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LicenseServiceTest {

    @InjectMocks
    private MatchService licenseService;

    @Mock
    private MatchRepository matchRepository;

    @Mock
    private SummaryMapper summaryMapper;

    private static final long CUSTOMER_ID = 123;
    private static final long MATCH_ID_1 = 1;
    private static final long MATCH_ID_2 = 2;
    private static final String PLAYER1 = "player1";
    private static final String PLAYER2 = "player2";
    private static final LocalDateTime START_DATE = LocalDateTime.now();
    private static final String EXPECTED_SUMMARY = PLAYER1 + " vs " + PLAYER2;

    private GetMatchesCommand requestLicensedMatchesCommand = GetMatchesCommand.builder()
            .customerId(CUSTOMER_ID)
            .summaryType(SummaryType.AvB)
            .build();

    private Match match1 = Match.builder().matchId(MATCH_ID_1)
            .startDate(START_DATE)
            .playerA(PLAYER1)
            .playerB(PLAYER2)
            .build();

    private Match match2 = Match.builder().matchId(MATCH_ID_2)
            .startDate(START_DATE)
            .playerA(PLAYER1)
            .playerB(PLAYER2)
            .build();

    private Match expectedMatch1 = match1.toBuilder()
            .summary(EXPECTED_SUMMARY)
            .build();

    private Match expectedMatch2 = match2.toBuilder()
            .summary(EXPECTED_SUMMARY)
            .build();

    private List<Match> matches;

    @BeforeEach
    public void init() {
        matches = asList(match1, match2);

        when(matchRepository.findByCustomerId(CUSTOMER_ID)).thenReturn(matches);
        when(summaryMapper.map(SummaryType.AvB, match1)).thenReturn(EXPECTED_SUMMARY);
        when(summaryMapper.map(SummaryType.AvB, match2)).thenReturn(EXPECTED_SUMMARY);
    }

    @Test
    public void fetchMatches() {
        List<Match> matches = licenseService.fetchLicensedMatches(requestLicensedMatchesCommand);
        assertThat(matches.size()).isEqualTo(2);
        assertThat(matches).containsExactlyInAnyOrder(expectedMatch1, expectedMatch2);
    }
}
