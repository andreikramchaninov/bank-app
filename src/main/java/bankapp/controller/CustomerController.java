package bankapp.controller;

import bankapp.entity.BankAccount;
import bankapp.entity.Customer;
import bankapp.model.CustomerModel;
import bankapp.service.BankAccountService;
import bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import javax.websocket.server.PathParam;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private CustomerModel customerModel;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String getCustomersPage(ModelMap modelMap) {
        List<Customer> customersList= customerService.findAll();
        modelMap.addAttribute("customersList", customersList);
        return "customers";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String postNewCustomer(@PathParam(value = "fullname") String fullname,
            @PathParam(value = "address") String address,
            @PathParam(value = "age") int age, ModelMap modelMap) {
        customerModel.addNewCustomer(fullname, address, age);
        List<Customer> customersList= customerService.findAll();
        modelMap.addAttribute("customersList", customersList);
        return "customers";
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public String postCustomerAccountsRequest(@PathVariable(value = "id") int id,
            ModelMap modelMap, Model model) {
        Customer customer = customerService.findById(id);
        List<BankAccount> accountsList = bankAccountService.findByCustomer(customer);
        model.addAttribute("customer", customer);
        modelMap.addAttribute("accountsList", accountsList);
        return "accounts";
    }
}
