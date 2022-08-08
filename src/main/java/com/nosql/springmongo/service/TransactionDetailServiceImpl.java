package com.nosql.springmongo.service;

import com.nosql.springmongo.model.Transaction;
import com.nosql.springmongo.model.TransactionDetail;
import com.nosql.springmongo.repository.TransactionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService{
    @Autowired
    TransactionDetailRepository transactionDetailRepository;

    @Override
    public TransactionDetail findById(String id) {
        return transactionDetailRepository.findById(id).orElseThrow(() -> {
            throw new Error("Transaction detail with id " + id + "not found");
        });
    }

    @Override
    public TransactionDetail update(String id, TransactionDetail transactionDetail) {
        TransactionDetail transactionDetailById = this.findById(id);
        transactionDetailById.setTransactionId(transactionDetail.getTransactionId());
        transactionDetailById.setProductId(transactionDetail.getProductId());
        transactionDetailById.setQuantity(transactionDetail.getQuantity());
        return transactionDetailRepository.save(transactionDetailById);
    }

    @Override
    public void delete(String id) {
        TransactionDetail detail = this.findById(id);
        transactionDetailRepository.delete(detail);
    }

    @Override
    public TransactionDetail create(TransactionDetail transactionDetail) {
        return transactionDetailRepository.save(transactionDetail);
    }

    @Override
    public List<TransactionDetail> findAll() {
        return (List<TransactionDetail>) transactionDetailRepository.findAll();
    }
}
