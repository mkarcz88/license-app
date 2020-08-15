package com.imgarena.licence.service;

import com.imgarena.licence.dao.MatchRepository;
import com.imgarena.licence.domain.Match;
import com.imgarena.licence.domain.GetMatchesCommand;
import com.imgarena.licence.domain.SummaryType;
import com.imgarena.licence.mapping.SummaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Autowired
    private SummaryMapper summaryMapper;

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> fetchLicensedMatches(GetMatchesCommand requestCustomerMatchesCommand) {
        List<Match> matches = matchRepository.findByCustomerId(requestCustomerMatchesCommand.getCustomerId());
        return fillSummaryForEachMatch(matches, requestCustomerMatchesCommand.getSummaryType());
    }

    private List<Match> fillSummaryForEachMatch(List<Match> matches, SummaryType summaryType) {
        return matches.stream().map(match -> match.toBuilder()
                .summary(summaryMapper.map(summaryType, match))
                .build())
                .collect(Collectors.toList());
    }
}
