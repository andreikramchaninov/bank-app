package bankapp.service;

import bankapp.entity.BankAccount;
import bankapp.entity.Customer;

import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */
public interface BankAccountService {

    BankAccount saveAndFlush(BankAccount bankAccount);

    List<BankAccount> findByCustomer(Customer customer);

}
