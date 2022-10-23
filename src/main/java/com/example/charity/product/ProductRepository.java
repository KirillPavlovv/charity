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

    public List<ProductResponse> getProducts() {
        return jdbcTemplate.query("""
                SELECT c.id, name, price, image, is_edible, quantity from products_category c
                JOIN products_stock s ON c.id=s.id
                ORDER BY is_edible DESC, name;
                """, new DataClassRowMapper<>(ProductResponse.class));
    }
}
