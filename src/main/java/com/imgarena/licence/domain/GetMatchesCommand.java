package com.imgarena.licence.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class GetMatchesCommand {
    private long customerId;
    private SummaryType summaryType;
}
