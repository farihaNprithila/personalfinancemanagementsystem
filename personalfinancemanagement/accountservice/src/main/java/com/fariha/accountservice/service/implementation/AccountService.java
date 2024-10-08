package com.fariha.accountservice.service.implementation;


import com.fariha.accountservice.common.enums.AccountType;
import com.fariha.accountservice.common.mapper.AccountMapper;
import com.fariha.accountservice.common.utils.MessageUtils;
import com.fariha.accountservice.data.entity.Account;
import com.fariha.accountservice.data.repository.AccountRepository;
import com.fariha.accountservice.presenter.domain.request.AccountRequest;
import com.fariha.accountservice.presenter.domain.response.AccountResponse;
import com.fariha.accountservice.service.interfaces.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public void createAccount(AccountRequest request) throws Exception {
        validateCreateRequest(request);

        Account account = accountMapper.mapToAccount(request);
        accountRepository.save(account);
    }

    @Override
    @Transactional
    public void updateAccount(AccountRequest request) throws Exception {
        validateUpdateRequest(request);

        Account account = accountMapper.mapToAccount(request);
        accountRepository.save(account);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountResponse getAccountDetails(String userName, String accountNo, AccountType accountType) throws Exception {
        Account account = accountRepository.findByUsernameAndAccountNoAndAccountType(userName,accountNo,accountType);
        if (Objects.isNull(account)) {
            throw new Exception(MessageUtils.ACCOUNT_DOESNOT_EXISTS);
        }
        return accountMapper.mapDetailsToUserResponse(account);
    }

    @Override
    public void deleteAccount(String userName, String accountNo, AccountType accountType) throws Exception {
        Account account = accountRepository.findByUsernameAndAccountNoAndAccountType(userName,accountNo,accountType);
        if (Objects.isNull(account)) {
            throw new Exception(MessageUtils.ACCOUNT_DOESNOT_EXISTS);
        }

        accountRepository.delete(account);
    }

    private void validateCreateRequest(AccountRequest request) throws Exception {
        Account account = accountRepository.findByUsernameAndAccountNoAndAccountType(request.getUsername(), request.getAccountNo(), request.getAccountType());
        if (!Objects.isNull(account)) {
            throw new Exception(MessageUtils.ACCOUNT_EXISTS);
        }
    }

    private void validateUpdateRequest(AccountRequest request) throws Exception {
        Account account = accountRepository.findByUsernameAndAccountNoAndAccountType(request.getUsername(), request.getAccountNo(), request.getAccountType());
        if (Objects.isNull(account)) {
            throw new Exception(MessageUtils.ACCOUNT_DOESNOT_EXISTS);
        }
    }
}
