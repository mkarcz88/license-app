package com.imgarena.licence.dao;

import com.imgarena.licence.domain.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MatchRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MatchRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Match> findByCustomerId(long customerId) {
        BeanPropertyRowMapper<Match> rowMapper = new BeanPropertyRowMapper<>(Match.class);
        return jdbcTemplate.query("SELECT * from matches m " +
                "LEFT JOIN licenses l ON (m.matchId = l.matchId) " +
                "WHERE l.customerId=?", rowMapper, customerId);
    }

}
