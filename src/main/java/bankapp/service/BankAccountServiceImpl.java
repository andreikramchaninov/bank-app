package bankapp.service;

import bankapp.dao.BankAccountRepository;
import bankapp.entity.BankAccount;
import bankapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount saveAndFlush(BankAccount bankAccount) {
        return bankAccountRepository.saveAndFlush(bankAccount);
    }

    @Override
    public List<BankAccount> findByCustomer(Customer customer) {
        return bankAccountRepository.findByCustomer(customer);
    }

    @Override
    public BankAccount findById(int id) {
        return bankAccountRepository.findById(id);
    }
}
