package bankapp.controller;

import bankapp.entity.BankAccount;
import bankapp.entity.BankOperation;
import bankapp.entity.Customer;
import bankapp.model.DateConverterModel;
import bankapp.service.BankAccountService;
import bankapp.service.BankOperationService;
import bankapp.service.CustomerService;
import bankapp.view.BankOperationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
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

    @Autowired
    private DateConverterModel dateConverterModel;

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
    public String filterByCustomer(@PathParam(value = "fullname") String fullname,
            ModelMap modelMap, Model model) {
        Customer customer = customerService.findByFullname(fullname);
        List<BankOperation> opsList = new ArrayList<>();
        if(customer != null) {
            List<BankAccount> accountList = bankAccountService.findByCustomer(customer);
            opsList = new ArrayList<>();
            for(BankAccount bankAccount : accountList) {
                List<BankOperation> operationsByAccount = bankOperationService.findByBankAccount(bankAccount);
                opsList.addAll(operationsByAccount);
            }
            model.addAttribute("message", "Filtered by customer: " + customer.getFullname());
        } else {
            opsList= bankOperationService.findAll();
            model.addAttribute("message", "Customer not selected "
                    + "or doesn't exist");
        }
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

    @RequestMapping(value = "/operations/bydate", method = RequestMethod.POST)
    public String filterByDate(@RequestParam(value = "startyear", required = false) String startYear,
            @RequestParam(value = "startmonth", required = false) String startMonth,
            @RequestParam(value = "startday", required = false) String startDay,
            @RequestParam(value = "finishyear", required = false) String finishYear,
            @RequestParam(value = "finishmonth", required = false) String finishMonth,
            @RequestParam(value = "finishday", required = false) String finishDay, ModelMap modelMap,
            Model model) {
        boolean start = dateConverterModel.checkIncomingDate(startYear, startMonth, startDay);
        boolean finish = dateConverterModel.checkIncomingDate(finishYear, finishMonth, finishDay);
        List<BankOperation> opsList = new ArrayList<>();
        if (!start && !finish) {
            model.addAttribute("message", "Date range not specified or "
                    + "invalid date format");
            opsList = bankOperationService.findAll();
        } else if (start && !finish) {
            Timestamp startTimestamp = dateConverterModel.convertDateToTimestamp(startYear,
                    startMonth, startDay);
            opsList = bankOperationService.findByOperationDateGreaterThan(startTimestamp);
            model.addAttribute("message", "Operations starting "
                    + "from " + startTimestamp);
        } else if (!start && finish) {
            Timestamp finishTimestamp = dateConverterModel.convertDateToTimestamp(finishYear,
                    finishMonth, finishDay);
            opsList = bankOperationService.findByOperationDateLessThan(finishTimestamp);
            model.addAttribute("message", "Operations before "
                    + finishTimestamp);
        } else if (start && finish) {
            Timestamp startTimestamp = dateConverterModel.convertDateToTimestamp(startYear,
                    startMonth, startDay);
            Timestamp finishTimestamp = dateConverterModel.convertDateToTimestamp(finishYear,
                    finishMonth, finishDay);
            List<BankOperation> opsListTruncatedLeft = bankOperationService.
                    findByOperationDateGreaterThan(startTimestamp);
            for(BankOperation bankOperation : opsListTruncatedLeft) {
                if(bankOperation.getOperationDate().before(finishTimestamp)) {
                    opsList.add(bankOperation);
                }
            }
            model.addAttribute("message", "Operations starting "
                    + "from " + startTimestamp + " and before " + finishTimestamp);
        }
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
}
