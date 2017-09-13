package bankapp.controller;

import bankapp.entity.BankAccount;
import bankapp.entity.BankOperation;
import bankapp.entity.Customer;
import bankapp.service.BankAccountService;
import bankapp.service.BankOperationService;
import bankapp.service.CustomerService;
import bankapp.view.BankOperationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import javax.websocket.server.PathParam;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */

@Controller
public class BankOperationController {

    @Autowired
    private BankOperationService bankOperationService;

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public String getOperationsPage(ModelMap modelMap) {
        List<BankOperation> opsList= bankOperationService.findAll();
        List<BankOperationView> opsView= new ArrayList<>();
        int i = 1;
        for (BankOperation b: opsList) {
            opsView.add(new BankOperationView(i, b));
            i++;
        }
        modelMap.addAttribute("operations", opsList);
        modelMap.addAttribute("customerList", customerService.findAll());
        modelMap.addAttribute("opsList", opsView);
        return "operations";
    }

    @RequestMapping(value = "/operations/bycustomer", method = RequestMethod.POST)
    public String filterByCustomer(@PathParam(value = "fullname") String fullname, ModelMap modelMap) {
        Customer customer = customerService.findByFullname(fullname);
        List<BankAccount> accountList = bankAccountService.findByCustomer(customer);
        List<BankOperation> operationList = new ArrayList<>();
        for(BankAccount bankAccount : accountList) {
            List<BankOperation> operationsByAccount = bankOperationService.findByBankAccount(bankAccount);
            operationList.addAll(operationsByAccount);
        }
        List<BankOperationView> viewList= new ArrayList<>();
        int i = 1;
        for (BankOperation b: operationList) {
            viewList.add(new BankOperationView(i, b));
            i++;
        }
        modelMap.addAttribute("operations", operationList);
        modelMap.addAttribute("customerList", customerService.findAll());
        modelMap.addAttribute("opsList", viewList);
        return "operations";
    }

    @RequestMapping(value = "/operations/bydate", method = RequestMethod.POST)
    public String filterByDate(@PathParam(value = "startyear") String startYear,
            @PathParam(value = "startmonth") String startMonth,
            @PathParam(value = "startday") String startDay,
            @PathParam(value = "finishyear") String finishYear,
            @PathParam(value = "finishmonth") String finishMonth,
            @PathParam(value = "finishday") String finishDay, ModelMap modelMap) {

    }
}
