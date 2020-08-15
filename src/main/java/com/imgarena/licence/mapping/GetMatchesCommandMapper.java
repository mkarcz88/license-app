package com.imgarena.licence.mapping;

import com.imgarena.licence.domain.GetMatchesCommand;
import com.imgarena.licence.domain.SummaryType;
import org.springframework.stereotype.Component;

@Component
public class GetMatchesCommandMapper {
    public GetMatchesCommand map(long customerId, String summaryType) {
        return GetMatchesCommand.builder()
                .customerId(customerId)
                .summaryType(SummaryType.build(summaryType))
                .build();
    }
}
