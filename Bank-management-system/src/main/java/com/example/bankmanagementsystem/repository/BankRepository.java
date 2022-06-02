package com.example.bankmanagementsystem.repository;

import com.example.bankmanagementsystem.modle.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {
}
