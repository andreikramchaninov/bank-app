package bankapp.controller;

import bankapp.entity.BankAccount;
import bankapp.entity.BankOperation;
import bankapp.entity.Customer;
import bankapp.model.AccountControllerModel;
import bankapp.model.BankAccountModel;
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

    @Autowired
    private AccountControllerModel accountControllerModel;

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

    @RequestMapping(value = "/account/deposit/{account}", method = RequestMethod.POST)
    public String depositMoney(@PathVariable(value = "account") int accountId,
            @PathParam(value = "money") BigDecimal money, ModelMap modelMap,
            Model model) {
        bankAccountModel.depositMoney(accountId, money);
        Customer customer = bankAccountService.findById(accountId).getCustomer();
        List<BankAccount> accountsList = bankAccountService.findByCustomer(customer);
        model.addAttribute("customer", customer);
        modelMap.addAttribute("accountsList", accountsList);
        return "accounts";
    }

    @RequestMapping(value = "/account/withdraw/{account}", method = RequestMethod.POST)
    public String withdrawMoney(@PathVariable(value = "account") int accountId,
            @PathParam(value = "money") BigDecimal money, ModelMap modelMap,
            Model model) {
        bankAccountModel.withdrawMoney(accountId, money);
        Customer customer = bankAccountService.findById(accountId).getCustomer();
        List<BankAccount> accountsList = bankAccountService.findByCustomer(customer);
        model.addAttribute("customer", customer);
        modelMap.addAttribute("accountsList", accountsList);
        return "accounts";
    }

    @RequestMapping(value = "/account/transfer/{account}", method = RequestMethod.POST)
    public String transferToAccount(@PathVariable(value = "account") int accountId,
            @PathParam(value = "money") BigDecimal money,
            @PathParam(value = "recipient") int recipientId, ModelMap modelMap,
            Model model) {
        System.out.println(money);
        System.out.println(recipientId);
        bankAccountModel.transferMoney(accountId, recipientId, money);
        Customer customer = bankAccountService.findById(accountId).getCustomer();
        List<BankAccount> accountsList = bankAccountService.findByCustomer(customer);
        model.addAttribute("customer", customer);
        modelMap.addAttribute("accountsList", accountsList);
        return "accounts";
    }

}
