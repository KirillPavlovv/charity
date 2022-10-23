package com.example.charity.product;

import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Data
public class ProductsStock {
    UUID id;
    int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductsStock that)) return false;
        return quantity == that.quantity && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }
}
