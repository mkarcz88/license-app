package com.imgarena.licence.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SummaryTypeTest {

    @Test
    void buildAvB() {
        SummaryType summaryType = SummaryType.build("AvB");
        assertThat(summaryType).isEqualTo(SummaryType.AvB);
    }

    @Test
    void buildAvBTime() {
        SummaryType summaryType = SummaryType.build("AvBTime");
        assertThat(summaryType).isEqualTo(SummaryType.AvBTime);
    }

    @Test
    void buildDefaultFromNull() {
        SummaryType summaryType = SummaryType.build(null);
        assertThat(summaryType).isEqualTo(SummaryType.AvB);
    }

    @Test
    void buildDefaultFromEmpty() {
        SummaryType summaryType = SummaryType.build("");
        assertThat(summaryType).isEqualTo(SummaryType.AvB);
    }

    @Test
    void buildDefaultFromIncorrectValue() {
        SummaryType summaryType = SummaryType.build("AvBCDE");
        assertThat(summaryType).isEqualTo(SummaryType.AvB);
    }

}
