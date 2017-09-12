package bankapp.service;

import bankapp.entity.BankOperation;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */
public interface BankOperationService {

    BankOperation saveAndFlush(BankOperation bankOperation);

    List<BankOperation> findByAccountId(int id);

    List<BankOperation> findByAccountIdAndOperationDate(int id, Timestamp timestamp);

}
