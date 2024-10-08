package com.fariha.accountservice.common.mapper;


import com.fariha.accountservice.data.entity.Account;
import com.fariha.accountservice.presenter.domain.request.AccountRequest;
import com.fariha.accountservice.presenter.domain.response.AccountResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class AccountMapper {
    public abstract Account mapToAccount(AccountRequest request);

    public abstract AccountResponse mapDetailsToUserResponse(Account entity);

}
