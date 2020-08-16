package com.imgarena.licence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    private long matchId;
    private LocalDateTime startDate;
    private String playerA;
    private String playerB;
    private String summary;

}
