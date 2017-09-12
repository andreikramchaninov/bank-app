package bankapp.service;

import bankapp.dao.CustomerRepository;
import bankapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveAndFlush(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findByCustomerId(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
