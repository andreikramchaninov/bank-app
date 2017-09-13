package bankapp.view;

import bankapp.entity.BankOperation;

import java.math.BigDecimal;

/**
 * Created by andreikramchaninov on 13.09.2017.
 */
public class BankOperationView {

    public int id;
    public int accountId;
    public String customer;
    public String type;
    public BigDecimal money;
    public String date;
    private BankOperation bankOperation;

    public BankOperationView(int id, BankOperation bankOperation) {
        this.id = id;
        this.accountId = bankOperation.getId();
        this.customer = bankOperation.getBankAccount().getCustomer().getFullname();
        this.type = (bankOperation.getOperationType() == 1) ? "Deposit" : "Withdrawal";
        this.money = bankOperation.getMoney();
        this.date = bankOperation.getOperationDate().toLocalDateTime().toString();
    }
}
