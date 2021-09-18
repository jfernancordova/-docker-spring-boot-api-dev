package com.api.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String uuid;

    private String name;

    private Double price;

    @Override
    public String toString() {
        return "Product{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
