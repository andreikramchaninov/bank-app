package bankapp.controller;

import bankapp.entity.BankAccount;
import bankapp.entity.Customer;
import bankapp.model.BankAccountModel;
import bankapp.service.BankAccountService;
import bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import javax.websocket.server.PathParam;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */

@Controller
public class BankAccountController {

    @Autowired
    private BankAccountModel bankAccountModel;

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String postNewAccount(@PathParam(value = "id") int id,
            @PathParam(value = "money") BigDecimal money, ModelMap modelMap,
            Model model) {
        Customer customer = customerService.findById(id);
        bankAccountModel.addNewAccount(customer, money);
        List<BankAccount> accountsList = bankAccountService.findByCustomer(customer);
        model.addAttribute("customer", customer);
        modelMap.addAttribute("accountsList", accountsList);
        return "accounts";
    }

}
