package bankapp.service;

import bankapp.dao.CustomerRepository;
import bankapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveAndFlush(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByFullname(String fullname) {
        return customerRepository.findByFullname(fullname);
    }

}
