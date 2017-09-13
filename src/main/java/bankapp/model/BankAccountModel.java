package bankapp.model;

import bankapp.entity.BankAccount;
import bankapp.entity.Customer;
import bankapp.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by andreikramchaninov on 13.09.2017.
 */
@Service
public class BankAccountModel {

    @Autowired
    private BankAccountService bankAccountService;

    public void addNewAccount(Customer customer, BigDecimal money) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setCustomer(customer);
        bankAccount.setMoney(money);
        bankAccountService.saveAndFlush(bankAccount);
    }

}
