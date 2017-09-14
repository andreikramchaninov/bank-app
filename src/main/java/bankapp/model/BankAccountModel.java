package bankapp.model;

import bankapp.entity.BankAccount;
import bankapp.entity.BankOperation;
import bankapp.entity.Customer;
import bankapp.service.BankAccountService;
import bankapp.service.BankOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by andreikramchaninov on 13.09.2017.
 */
@Service
public class BankAccountModel {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private BankOperationService bankOperationService;

    public void addNewAccount(Customer customer, BigDecimal money) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setCustomer(customer);
        bankAccount.setMoney(money);
        BankOperation bankOperation = new BankOperation();
        bankOperation.setBankAccount(bankAccount);
        bankOperation.setOperationType((byte) 1);
        bankOperation.setMoney(money);
        Timestamp timestamp = new Timestamp(new Date().getTime());
        bankOperation.setOperationDate(timestamp);
        bankAccountService.saveAndFlush(bankAccount);
        bankOperationService.saveAndFlush(bankOperation);
    }

    public void depositMoney(int id, BigDecimal money) {
        BankAccount bankAccount = bankAccountService.findById(id);
        bankAccount.setMoney(bankAccount.getMoney().add(money));
        BankOperation bankOperation = new BankOperation();
        bankOperation.setBankAccount(bankAccount);
        bankOperation.setOperationType((byte) 1);
        bankOperation.setMoney(money);
        Timestamp timestamp = new Timestamp(new Date().getTime());
        bankOperation.setOperationDate(timestamp);
        bankAccountService.saveAndFlush(bankAccount);
        bankOperationService.saveAndFlush(bankOperation);
    }

    public void withdrawMoney(int id, BigDecimal money) {
        BankAccount bankAccount = bankAccountService.findById(id);
        bankAccount.setMoney(bankAccount.getMoney().subtract(money));
        BankOperation bankOperation = new BankOperation();
        bankOperation.setBankAccount(bankAccount);
        bankOperation.setOperationType((byte) 0);
        bankOperation.setMoney(money);
        bankOperation.setOperationDate(new Timestamp(new Date().getTime()));
        bankAccountService.saveAndFlush(bankAccount);
        bankOperationService.saveAndFlush(bankOperation);
    }

    public void transferMoney(int accountId, int recipientId,
            BigDecimal money) {
        BankAccount sourceAccount = bankAccountService.findById(accountId);
        BankAccount recipientAccount = bankAccountService.findById(recipientId);
        sourceAccount.setMoney(sourceAccount.getMoney().subtract(money));
        recipientAccount.setMoney(recipientAccount.getMoney().add(money));
        BankOperation subtractOperation = new BankOperation();
        subtractOperation.setBankAccount(sourceAccount);
        subtractOperation.setOperationType((byte) 0);
        subtractOperation.setMoney(money);
        subtractOperation.setOperationDate(new Timestamp(new Date().getTime()));
        BankOperation addOperation = new BankOperation();
        addOperation.setBankAccount(recipientAccount);
        addOperation.setOperationType((byte) 1);
        addOperation.setMoney(money);
        addOperation.setOperationDate(new Timestamp(new Date().getTime()));
        bankAccountService.saveAndFlush(sourceAccount);
        bankAccountService.saveAndFlush(recipientAccount);
        bankOperationService.saveAndFlush(subtractOperation);
        bankOperationService.saveAndFlush(addOperation);
    }

}
