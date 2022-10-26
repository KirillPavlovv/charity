package com.example.charity.order;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;


    public OrderRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(Order order) {
        jdbcTemplate.update("""
                INSERT INTO orders (id, user_id, total_price)
                VALUES (:id, :userId, :totalPrice)
                """, new BeanPropertySqlParameterSource(order));
    }
}
