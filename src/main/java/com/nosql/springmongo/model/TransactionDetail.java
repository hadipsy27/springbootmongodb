package com.nosql.springmongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transactionDetails")
public class TransactionDetail {

    @Id
    public String id;
    public String transactionId = new Transaction().getId();
    public String productId = new Product().getId();
    public String quantity;
}
