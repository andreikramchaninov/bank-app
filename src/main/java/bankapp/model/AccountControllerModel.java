package bankapp.model;

import bankapp.entity.BankAccount;
import bankapp.entity.Customer;
import bankapp.service.BankAccountService;
import bankapp.service.BankOperationService;
import bankapp.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by andreikramchaninov on 13.09.2017.
 */
@Service
public class AccountControllerModel {

    public void generateAccountsPage(CustomerService customerService,
            BankAccountService bankAccountService, int id, Model model,
            ModelMap modelMap) {
        Customer customer = customerService.findById(id);
        List<BankAccount> accountsList = bankAccountService.findByCustomer(customer);
        model.addAttribute("customer", customer);
        modelMap.addAttribute("accountsList", accountsList);
    }

}
