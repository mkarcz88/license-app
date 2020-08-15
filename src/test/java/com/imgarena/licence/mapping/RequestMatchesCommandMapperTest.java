package com.imgarena.licence.mapping;

import com.imgarena.licence.domain.GetMatchesCommand;
import com.imgarena.licence.domain.SummaryType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestMatchesCommandMapperTest {

    private GetMatchesCommandMapper getMatchesCommandMapper = new GetMatchesCommandMapper();

    private static final long CUSTOMER_ID = 123;

    @Test
    public void AvBSummaryType() {
        GetMatchesCommand requestCustomerMatchesCommand = getMatchesCommandMapper.map(CUSTOMER_ID, "AvB");
        assertThat(requestCustomerMatchesCommand.getCustomerId()).isEqualTo(CUSTOMER_ID);
        assertThat(requestCustomerMatchesCommand.getSummaryType()).isEqualTo(SummaryType.AvB);
    }

    @Test
    public void AvBTimeSummaryType() {
        GetMatchesCommand requestCustomerMatchesCommand = getMatchesCommandMapper.map(CUSTOMER_ID, "AvBTime");
        assertThat(requestCustomerMatchesCommand.getCustomerId()).isEqualTo(CUSTOMER_ID);
        assertThat(requestCustomerMatchesCommand.getSummaryType()).isEqualTo(SummaryType.AvBTime);
    }

    @Test
    public void SummaryTypeIsIncorrect() {
        GetMatchesCommand requestCustomerMatchesCommand = getMatchesCommandMapper.map(CUSTOMER_ID, "potatoes");
        assertThat(requestCustomerMatchesCommand.getCustomerId()).isEqualTo(CUSTOMER_ID);
        assertThat(requestCustomerMatchesCommand.getSummaryType()).isEqualTo(SummaryType.AvB);
    }

    @Test
    public void SummaryTypeIsEmpty() {
        GetMatchesCommand requestCustomerMatchesCommand = getMatchesCommandMapper.map(CUSTOMER_ID, "");
        assertThat(requestCustomerMatchesCommand.getCustomerId()).isEqualTo(CUSTOMER_ID);
        assertThat(requestCustomerMatchesCommand.getSummaryType()).isEqualTo(SummaryType.AvB);
    }

    @Test
    public void SummaryTypeIsNull() {
        GetMatchesCommand requestCustomerMatchesCommand = getMatchesCommandMapper.map(CUSTOMER_ID, null);
        assertThat(requestCustomerMatchesCommand.getCustomerId()).isEqualTo(CUSTOMER_ID);
        assertThat(requestCustomerMatchesCommand.getSummaryType()).isEqualTo(SummaryType.AvB);
    }
}
