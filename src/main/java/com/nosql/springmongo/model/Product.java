package com.nosql.springmongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("products")
public class Product {
    @Id
    public String id;
    public String name;
    public Float price;

}
