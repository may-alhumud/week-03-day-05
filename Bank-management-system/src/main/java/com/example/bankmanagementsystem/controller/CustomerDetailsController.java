package com.example.bankmanagementsystem.controller;

import com.example.bankmanagementsystem.DTO.API;
import com.example.bankmanagementsystem.DTO.CustomerDetailsDTO;
import com.example.bankmanagementsystem.modle.Bank;
import com.example.bankmanagementsystem.modle.CustomerDetails;
import com.example.bankmanagementsystem.modle.Customers;
import com.example.bankmanagementsystem.repository.CustomerDetailsRepository;
import com.example.bankmanagementsystem.repository.CustomersRepository;
import com.example.bankmanagementsystem.service.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customerdetail")
@RequiredArgsConstructor
public class CustomerDetailsController {
    private final CustomerDetailsService customerDetailsService;
    private final CustomersRepository  customerRepository;
    private final CustomerDetailsRepository customerDetailsRepository;
    Logger logger= LoggerFactory.getLogger(CustomerDetailsController.class);


    @GetMapping
    public ResponseEntity getCustomerDetails(){
        logger.info("Get All CustomerDetails");
        return ResponseEntity.status(HttpStatus.OK).body(customerDetailsService.getCustomerDetails());
    }

    @PostMapping("/details")
    public ResponseEntity addCustomerDetails(@RequestBody CustomerDetailsDTO cd){
        logger.info("ADD CustomerDetails");
        Customers customer=customerRepository.findById(cd.getCustomerId()).get();
        CustomerDetails customerDetails=new CustomerDetails(cd.getCustomerId(),cd.getAge(),cd.getBalance(),customer);
        customer.setCustomerDetails(customerDetails);

        customerDetailsRepository.save(customerDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Customer added !",201));
    }

    @PostMapping("/withdraw/{cid}/{amunt}")
    public ResponseEntity withdraw(@PathVariable Integer cid,@PathVariable Integer amunt){
        customerDetailsService.withdraw(cid, amunt);
        return ResponseEntity.status(201).body("The processes done");

    }

    @PostMapping("/deposit/{cid}/{amunt}")
    public ResponseEntity deposit(@PathVariable Integer cid,@PathVariable Integer amunt){
        customerDetailsService.deposit(cid, amunt);
        return ResponseEntity.status(201).body("The processes done");

    }

}
