package com.example.bankmanagementsystem.controller;

import com.example.bankmanagementsystem.DTO.API;
import com.example.bankmanagementsystem.DTO.CustomerDTO;
import com.example.bankmanagementsystem.modle.Bank;
import com.example.bankmanagementsystem.modle.CustomerDetails;
import com.example.bankmanagementsystem.modle.Customers;
import com.example.bankmanagementsystem.repository.BankRepository;
import com.example.bankmanagementsystem.repository.CustomersRepository;
import com.example.bankmanagementsystem.service.BankService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/bank")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;
    private final CustomersRepository customersRepository;
    private final BankRepository bankRepository;
    Logger logger= LoggerFactory.getLogger(BankController.class);


    @GetMapping
    public ResponseEntity<List<Bank>> getBank(){
        logger.info("GET ALL BANK");
        List<Bank> banks=bankService.getBank();
        return ResponseEntity.status(HttpStatus.OK).body(banks);
    }

    @PostMapping("/register")
    public ResponseEntity<API> addBank(@RequestBody @Valid Bank bank) {
        logger.info("ADD BANK");
        bankService.addBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New Bank added !",201));
    }






}
