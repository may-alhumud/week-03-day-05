package com.example.bankmanagementsystem.service;

import com.example.bankmanagementsystem.controller.CustomersController;
import com.example.bankmanagementsystem.modle.Customers;
import com.example.bankmanagementsystem.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomersService {
    private final CustomersRepository customersRepository;

    public List<Customers> getCustomers() {
        return customersRepository.findAll();
    }


    public void addCustomers(Customers customers) {
         customersRepository.save(customers);
    }
}
