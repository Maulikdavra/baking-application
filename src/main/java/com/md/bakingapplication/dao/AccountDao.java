package com.md.bakingapplication.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDao {
    private Long id;
    private String accountHolderName;
    private double balance;
}
