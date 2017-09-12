package bankapp.service;

import bankapp.dao.BankAccountRepository;
import bankapp.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount saveAndFlush(BankAccount bankAccount) {
        return bankAccountRepository.saveAndFlush(bankAccount);
    }

    @Override
    public List<BankAccount> findByCustomerId(int id) {
        return bankAccountRepository.findByCustomerId(id);
    }
}
