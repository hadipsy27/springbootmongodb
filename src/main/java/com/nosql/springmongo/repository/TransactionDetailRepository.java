package com.nosql.springmongo.repository;

import com.nosql.springmongo.model.TransactionDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailRepository extends CrudRepository<TransactionDetail, String> {
}
