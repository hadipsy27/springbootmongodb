package com.nosql.springmongo.service;

import com.nosql.springmongo.model.Transaction;
import com.nosql.springmongo.model.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {
    TransactionDetail create(TransactionDetail transactionDetail);
    List<TransactionDetail> findAll();
    TransactionDetail findById(String id);
    TransactionDetail update(String id, TransactionDetail transactionDetail);
    void delete(String id);

}
