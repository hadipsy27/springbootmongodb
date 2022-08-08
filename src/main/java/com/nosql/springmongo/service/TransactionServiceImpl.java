package com.nosql.springmongo.service;

import com.nosql.springmongo.model.Transaction;
import com.nosql.springmongo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public Transaction findById(String id) {
        return transactionRepository.findById(id).orElseThrow(() -> {
            throw new Error("Product with id "+ id + " not found");
        });
    }

    @Override
    public Transaction update(String id, Transaction transaction) {
        Transaction transactionById = this.findById(id);
        transactionById.setId(transactionById.getId());
        transactionById.setCustomerName(transaction.getCustomerName());
        transactionById.setTransactionDetails(transaction.getTransactionDetails());
        transactionById.setPaid(transactionById.isPaid());
        transactionById.setCreated_at(transaction.getCreated_at());
        return transactionRepository.save(transactionById);

    }

    @Override
    public void delete(String id) {
        Transaction transaction = this.findById(id);
        transactionRepository.delete(transaction);
    }
}
