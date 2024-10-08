package com.fariha.accountservice.presenter.domain.response;

import com.fariha.accountservice.common.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountResponse {

    private Long id;

    private String username;

    private String accountName;

    private String accountNo;

    private AccountType accountType;

    private BigDecimal balance;

}
