package bankapp.dao;

import bankapp.entity.BankOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */
public interface BankOperationRepository extends JpaRepository<BankOperation, Integer> {

    BankOperation saveAndFlush(BankOperation bankOperation);

    List<BankOperation> findByAccountId(int id);

    List<BankOperation> findByAccountIdAndOperationDate(int id, Timestamp timestamp);

}
