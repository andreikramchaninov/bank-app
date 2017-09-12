package bankapp.service;

import bankapp.entity.Customer;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */
public interface CustomerService {

    Customer saveAndFlush(Customer customer);

    Customer findById(int id);

}
