package com.example.charity.product;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductResponse> getProducts() {
        return jdbcTemplate.query("""
                SELECT c.id, name, price, image, is_edible, quantity FROM products_category c
                JOIN products_stock s ON c.id=s.id
                ORDER BY is_edible DESC, name;
                """, new DataClassRowMapper<>(ProductResponse.class));
    }

    public UUID getProductIdByName(String name) {
        return jdbcTemplate.queryForObject("""
                SELECT id FROM products_category WHERE name=:name;
                """, Map.of("name", name), UUID.class);
    }
}
