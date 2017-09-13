package bankapp.controller;

import bankapp.entity.BankOperation;
import bankapp.entity.Customer;
import bankapp.service.BankOperationService;
import bankapp.view.BankOperationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */

@Controller
public class BankOperationController {

    @Autowired
    private BankOperationService bankOperationService;

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public String getOperationsPage(ModelMap modelMap) {
        List<BankOperation> opsList= bankOperationService.findAll();
        List<BankOperationView> opsView= new ArrayList<>();
        int i = 1;
        for (BankOperation b: opsList) {
            opsView.add(new BankOperationView(i, b));
            i++;
        }
        modelMap.addAttribute("opsList", opsView);
        return "operations";
    }

}
