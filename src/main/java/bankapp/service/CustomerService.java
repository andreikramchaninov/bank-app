package bankapp.service;

import bankapp.entity.Customer;

import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */
public interface CustomerService {

    Customer saveAndFlush(Customer customer);

    Customer findById(int id);

    List<Customer> findAll();

    Customer findByFullname(String fullname);

}
