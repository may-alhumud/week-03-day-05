package com.example.bankmanagementsystem.service;

import com.example.bankmanagementsystem.modle.Bank;
import com.example.bankmanagementsystem.modle.CustomerDetails;
import com.example.bankmanagementsystem.repository.CustomerDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {
     private final CustomerDetailsRepository customerDetailsRepository;

     public List<CustomerDetails> getCustomerDetails() {
          return customerDetailsRepository.findAll();
     }


     public void addCustomerDetails(CustomerDetails customerDetails) {
          customerDetailsRepository.save(customerDetails);
     }

     public void  withdraw(Integer custmerId,Integer amount){
          CustomerDetails customerDetails=customerDetailsRepository.findById(custmerId)
                  .orElseThrow(()->new RuntimeException("invild id"));
          if (customerDetails.getBalance()<amount){
               throw new RuntimeException("balance less than amount");

          }
          customerDetails.setBalance(customerDetails.getBalance()-amount);
          customerDetailsRepository.save(customerDetails);

     }

     public void  deposit(Integer custmerId,Integer amount){
          CustomerDetails customerDetails=customerDetailsRepository.findById(custmerId).get();
          customerDetails.setBalance(customerDetails.getBalance()+amount);
          customerDetailsRepository.save(customerDetails);

     }

}
