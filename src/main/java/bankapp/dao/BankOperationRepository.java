package bankapp.dao;

import bankapp.entity.BankAccount;
import bankapp.entity.BankOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */
public interface BankOperationRepository extends JpaRepository<BankOperation, Integer> {

    BankOperation saveAndFlush(BankOperation bankOperation);

    List<BankOperation> findByBankAccount(BankAccount bankAccount);

    List<BankOperation> findByBankAccountAndOperationDate(BankAccount bankAccount, Timestamp timestamp);

    List<BankOperation> findByOperationDateGreaterThan(Timestamp timestamp);

    List<BankOperation> findByOperationDateLessThan(Timestamp timestamp);

}
