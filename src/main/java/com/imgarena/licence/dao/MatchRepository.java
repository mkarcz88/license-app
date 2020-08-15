package com.imgarena.licence.dao;

import com.imgarena.licence.domain.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MatchRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Match> findByCustomerId(long customerId) {
        return jdbcTemplate.query("SELECT * from matches m " +
                        "LEFT JOIN licenses l ON (m.matchId = l.matchId) " +
                        "WHERE l.customerId=?", new Object[]{
                        customerId
                },
                new BeanPropertyRowMapper<>(Match.class));
    }
}
