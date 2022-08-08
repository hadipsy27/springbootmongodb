package com.nosql.springmongo.controller;

import com.nosql.springmongo.model.TransactionDetail;
import com.nosql.springmongo.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction-details")
public class TransactionDetailController {

    @Autowired
    TransactionDetailService transactionDetailService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TransactionDetail transactionDetail){
       TransactionDetail detailService = transactionDetailService.create(transactionDetail);
        return ResponseEntity.ok(detailService);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        Iterable<TransactionDetail> detailService = transactionDetailService.findAll();
        return ResponseEntity.ok(detailService);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody TransactionDetail transactionDetailPayload){
        try {
            TransactionDetail transactionDetail = transactionDetailService.update(id, transactionDetailPayload);
            return ResponseEntity.ok(transactionDetail);
        }catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        try {
            transactionDetailService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);

        }
    }

}
