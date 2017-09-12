package bankapp.controller;

import bankapp.entity.BankAccount;
import bankapp.entity.Customer;
import bankapp.service.BankAccountService;
import bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    BankAccountService bankAccountService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCustomersPage(ModelMap modelMap) {
        List<Customer> customersList= customerService.findAll();
        modelMap.addAttribute("customersList", customersList);
        return "customers";
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String postCustomerAccountsRequest(@RequestParam(value = "id") int id,
            ModelMap modelMap) {
        Customer customer = customerService.findById(id);
        List<BankAccount> accountsList = bankAccountService.findByCustomer(customer);
        modelMap.addAttribute("accountsList", accountsList);
        return "accounts";
    }
}
