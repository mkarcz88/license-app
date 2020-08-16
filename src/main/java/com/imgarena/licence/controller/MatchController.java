package com.imgarena.licence.controller;

import com.imgarena.licence.domain.Match;
import com.imgarena.licence.domain.SummaryType;
import com.imgarena.licence.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping(value = "/match/{customerId}")
    @ResponseBody
    public List<Match> getMatches(@PathVariable final long customerId, @RequestParam(value = "summaryType", required = false) String summaryType) {
        return matchService.fetchLicensedMatches(customerId, SummaryType.build(summaryType));
    }

}
