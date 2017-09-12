package bankapp.dao;

import bankapp.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

    BankAccount saveAndFlush(BankAccount bankAccount);

    List<BankAccount> findByCustomerId(int id);

}
