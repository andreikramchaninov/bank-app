package bankapp.model;

import bankapp.entity.Customer;
import bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by andreikramchaninov on 13.09.2017.
 */

@Service
public class CustomerModel {

    @Autowired
    private CustomerService customerService;

    public void addNewCustomer(String fullname, String address, int age) {
        Customer customer = new Customer();
        customer.setFullname(fullname);
        customer.setAddress(address);
        customer.setAge(age);
        customerService.saveAndFlush(customer);
    }

}
