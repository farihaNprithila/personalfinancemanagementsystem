package com.fariha.accountservice.presenter.rest.api;

import com.fariha.accountservice.common.enums.AccountType;
import com.fariha.accountservice.common.utils.AppUtils;
import com.fariha.accountservice.common.utils.MessageUtils;
import com.fariha.accountservice.presenter.domain.request.AccountRequest;
import com.fariha.accountservice.presenter.domain.response.AccountResponse;
import com.fariha.accountservice.service.interfaces.IAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppUtils.BASE_URL)
public class AccountResource {

    private final IAccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<?> createAccount(@RequestBody @Valid AccountRequest request) throws Exception {
        accountService.createAccount(request);
        return ResponseEntity.ok(MessageUtils.OPERATION_SUCCESSFUL);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateAccount(@RequestBody @Valid AccountRequest request) throws Exception {
        accountService.updateAccount(request);
        return ResponseEntity.ok(MessageUtils.OPERATION_SUCCESSFUL);
    }

    @GetMapping("/details/{userName}/{accountNo}/{accountType}")
    public ResponseEntity<AccountResponse> getAccountDetails(@PathVariable String userName,
                                                             @PathVariable String accountNo,
                                                             @PathVariable AccountType accountType) throws Exception {
        AccountResponse response = accountService.getAccountDetails(userName, accountNo, accountType);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/delete/{userName}/{accountNo}/{accountType}")
    public ResponseEntity<?> deleteAccount(@PathVariable String userName,
                                           @PathVariable String accountNo,
                                           @PathVariable AccountType accountType) throws Exception {
        accountService.deleteAccount(userName, accountNo, accountType);
        return ResponseEntity.ok(MessageUtils.OPERATION_SUCCESSFUL);
    }
}
