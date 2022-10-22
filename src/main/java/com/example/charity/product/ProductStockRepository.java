package com.example.charity.product;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductStockRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductStockRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void changeStock(ProductsStock productsStock) {
        jdbcTemplate.update("""
                UPDATE products_stock SET quantity = quantity - :quantity
                WHERE id=:id;
                 """, new BeanPropertySqlParameterSource(productsStock));

    }
}
