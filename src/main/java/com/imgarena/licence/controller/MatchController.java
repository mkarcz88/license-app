package com.imgarena.licence.controller;

import com.imgarena.licence.domain.Match;
import com.imgarena.licence.domain.GetMatchesCommand;
import com.imgarena.licence.mapping.GetMatchesCommandMapper;
import com.imgarena.licence.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    @Autowired
    private GetMatchesCommandMapper getMatchesCommandMapper;

    @Autowired
    private MatchService licenseService;

    @RequestMapping(value = "/match/{customerId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Match> getMatches(@PathVariable final long customerId, @RequestParam(value = "summaryType", required = false) String summaryType) {
        GetMatchesCommand requestLicensedMatchesCommand = getMatchesCommandMapper.map(customerId, summaryType);
        return licenseService.fetchLicensedMatches(requestLicensedMatchesCommand);
    }

}
