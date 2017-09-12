package bankapp.service;

import bankapp.dao.BankOperationRepository;
import bankapp.entity.BankOperation;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */
public class BankOperationServiceImpl implements BankOperationService {

    @Autowired
    private BankOperationRepository bankOperationRepository;

    @Override
    public BankOperation saveAndFlush(BankOperation bankOperation) {
        return bankOperationRepository.saveAndFlush(bankOperation);
    }

    @Override
    public List<BankOperation> findByAccountId(int id) {
        return bankOperationRepository.findByAccountId(id);
    }

    @Override
    public List<BankOperation> findByAccountIdAndOperationDate(int id, Timestamp timestamp) {
        return bankOperationRepository.findByAccountIdAndOperationDate(id, timestamp);
    }
}
