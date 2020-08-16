package com.imgarena.licence.service;

import com.imgarena.licence.dao.MatchRepository;
import com.imgarena.licence.domain.Match;
import com.imgarena.licence.domain.SummaryType;
import com.imgarena.licence.mapping.SummaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private final SummaryMapper summaryMapper;
    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(SummaryMapper summaryMapper, MatchRepository matchRepository) {
        this.summaryMapper = summaryMapper;
        this.matchRepository = matchRepository;
    }

    public List<Match> fetchLicensedMatches(long customerId, SummaryType summaryType) {
        List<Match> matches = matchRepository.findByCustomerId(customerId);
        return fillSummaryForEachMatch(matches, summaryType);
    }

    private List<Match> fillSummaryForEachMatch(List<Match> matches, SummaryType summaryType) {
        return matches.stream().map(match -> match.toBuilder()
                .summary(summaryMapper.map(summaryType, match))
                .build())
                .collect(Collectors.toList());
    }

}
