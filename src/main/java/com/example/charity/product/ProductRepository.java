package com.example.charity.product;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> getProducts() {
        return jdbcTemplate.query("""
                SELECT * from products""",
                new DataClassRowMapper<>(Product.class));
    }
}
