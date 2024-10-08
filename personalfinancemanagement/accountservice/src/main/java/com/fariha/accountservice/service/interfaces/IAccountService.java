package com.fariha.accountservice.service.interfaces;

import com.fariha.accountservice.common.enums.AccountType;
import com.fariha.accountservice.presenter.domain.request.AccountRequest;
import com.fariha.accountservice.presenter.domain.response.AccountResponse;

public interface IAccountService {
    void createAccount(AccountRequest request) throws Exception;

    void updateAccount(AccountRequest request) throws Exception;

    AccountResponse getAccountDetails(String userName, String accountNo, AccountType accountType) throws Exception;

    void deleteAccount(String userName, String accountNo, AccountType accountType) throws Exception;
}
