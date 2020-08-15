package com.imgarena.licence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matches")
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matchId")
    private long matchId;
    @Column(name = "startDate")
    private LocalDateTime startDate;
    @Column(name = "playerA")
    private String playerA;
    @Column(name = "playerB")
    private String playerB;
    private String summary;
}
