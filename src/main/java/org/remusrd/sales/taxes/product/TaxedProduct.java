package org.remusrd.sales.taxes.product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxedProduct implements Product {
    private final String name;
    private final BigDecimal price;

    public TaxedProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public BigDecimal getTaxAmount() {
        return TaxStrategy.basic().apply(price);
    }
}
