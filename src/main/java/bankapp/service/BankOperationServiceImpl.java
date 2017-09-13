package bankapp.service;

import bankapp.dao.BankOperationRepository;
import bankapp.entity.BankAccount;
import bankapp.entity.BankOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */

@Service
public class BankOperationServiceImpl implements BankOperationService {

    @Autowired
    private BankOperationRepository bankOperationRepository;

    @Override
    public BankOperation saveAndFlush(BankOperation bankOperation) {
        return bankOperationRepository.saveAndFlush(bankOperation);
    }

    @Override
    public List<BankOperation> findByBankAccount(BankAccount bankAccount) {
        return bankOperationRepository.findByBankAccount(bankAccount);
    }

    @Override
    public List<BankOperation> findByBankAccountAndOperationDate(BankAccount bankAccount, Timestamp timestamp) {
        return bankOperationRepository.findByBankAccountAndOperationDate(bankAccount, timestamp);
    }

    @Override
    public List<BankOperation> findAll() {
        return bankOperationRepository.findAll();
    }
}
