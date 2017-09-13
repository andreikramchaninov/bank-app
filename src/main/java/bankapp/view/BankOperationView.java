package bankapp.view;

import bankapp.entity.BankOperation;

import java.math.BigDecimal;

/**
 * Created by andreikramchaninov on 13.09.2017.
 */
public class BankOperationView {

    private int id;
    private int accountId;
    private String type;
    private BigDecimal money;
    private String date;
    private BankOperation bankOperation;

    public BankOperationView(int id, BankOperation bankOperation) {
        this.id = id;
        this.accountId = bankOperation.getId();
        this.type = (bankOperation.getOperationType() == 1) ? "Deposit" : "Withdrawal";
        this.money = bankOperation.getMoney();
        this.date = bankOperation.getOperationDate().toLocalDateTime().toString();
    }
}
