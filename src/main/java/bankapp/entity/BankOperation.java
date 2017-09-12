package bankapp.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by andreikramchaninov on 12.09.2017.
 */

@Entity
@Table(name = "bank_operation")
public class BankOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private BankAccount bankAccount;

    @Column(name = "op_type")
    private byte operationType;

    @Column(name = "money")
    private BigDecimal money;

    @Column(name = "op_date")
    private Timestamp operationDate;

    public BankOperation() {
    }

    public BankOperation(BankAccount bankAccount, byte operationType, BigDecimal money,
            Timestamp operationDate) {
        this.bankAccount = bankAccount;
        this.operationType = operationType;
        this.money = money;
        this.operationDate = operationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public byte getOperationType() {
        return operationType;
    }

    public void setOperationType(byte operationType) {
        this.operationType = operationType;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Timestamp getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Timestamp operationDate) {
        this.operationDate = operationDate;
    }

    @Override
    public String toString() {
        return "BankOperation{" +
                "id=" + id +
                ", bankAccount=" + bankAccount +
                ", operationType=" + operationType +
                ", money=" + money +
                ", operationDate=" + operationDate +
                '}';
    }
}
