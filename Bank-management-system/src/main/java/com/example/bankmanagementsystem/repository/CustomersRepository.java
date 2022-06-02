package com.example.bankmanagementsystem.repository;

import com.example.bankmanagementsystem.modle.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,Integer> {
}
