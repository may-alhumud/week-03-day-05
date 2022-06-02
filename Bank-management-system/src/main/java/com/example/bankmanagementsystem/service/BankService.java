package com.example.bankmanagementsystem.service;

import com.example.bankmanagementsystem.modle.Bank;
import com.example.bankmanagementsystem.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepository bankRepository;

    public List<Bank> getBank() {
        return bankRepository.findAll();
    }


    public void addBank(Bank bank) {
        bankRepository.save(bank);
    }
}
