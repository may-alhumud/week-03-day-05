package com.example.bankmanagementsystem.controller;

import com.example.bankmanagementsystem.DTO.API;
import com.example.bankmanagementsystem.DTO.CustomerDTO;
import com.example.bankmanagementsystem.modle.Bank;
import com.example.bankmanagementsystem.modle.CustomerDetails;
import com.example.bankmanagementsystem.modle.Customers;
import com.example.bankmanagementsystem.repository.BankRepository;
import com.example.bankmanagementsystem.repository.CustomersRepository;
import com.example.bankmanagementsystem.service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomersController {
    private final CustomersService customersServices;
    private final CustomersRepository customersRepository;
    private final BankRepository bankRepository;

    Logger logger= LoggerFactory.getLogger(CustomersController.class);



    @GetMapping
    public ResponseEntity<List<Customers>> getCustomer(){
        logger.info("Get All Customer");
        List<Customers> customers=customersServices.getCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @PostMapping("/register")
    public ResponseEntity<API> addCustomerDetails(@RequestBody @Valid Customers customer) {
        logger.info("Add CustomerDetails");
        customersServices.addCustomers(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New Bank added !",201));
    }

    @PostMapping("/addCustomerDetails")
    public ResponseEntity addaddCustomerDetails1(@RequestBody CustomerDTO customerDTO){
        logger.info("add CustomerDetails");
        Bank bank=bankRepository.findById(customerDTO.getBankId()).orElseThrow();
        Customers customers=new Customers(customerDTO.getBankId(),customerDTO.getUsername(),new CustomerDetails(),bank);
        bank.getCustomersSet().add(customers);
        customersRepository.save(customers);
        return ResponseEntity.status(HttpStatus.OK).body(customersRepository.findAll());
    }



    }






