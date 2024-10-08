package com.fariha.accountservice.data.repository;

import com.fariha.accountservice.common.enums.AccountType;
import com.fariha.accountservice.data.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsernameAndAccountNoAndAccountType(String username, String accountNo, AccountType accountType);

}
