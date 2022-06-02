package com.example.bankmanagementsystem.repository;

import com.example.bankmanagementsystem.modle.CustomerDetails;
import com.example.bankmanagementsystem.modle.Customers;
import com.example.bankmanagementsystem.service.CustomerDetailsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails,Integer> {

}
