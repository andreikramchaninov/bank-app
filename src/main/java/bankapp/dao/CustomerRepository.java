package bankapp.dao;

import bankapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer saveAndFlush(Customer customer);

    Customer findById(int id);

}
