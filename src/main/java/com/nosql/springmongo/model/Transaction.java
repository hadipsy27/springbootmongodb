package com.nosql.springmongo.model;

import com.nosql.springmongo.config.DateTimeIndonesia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transactions")
public class Transaction {

    @Id
    public String id;
    public String customerName;
    public List<TransactionDetail> transactionDetails;
    public boolean isPaid;
    public String created_at = new DateTimeIndonesia().getDateTimeIndo();
}
