package bankapp.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "op_type")
    private byte operationType;

    @Column(name = "money")
    private BigDecimal money;

    @Column(name = "op_date")
    private Timestamp operationDate;

    public BankOperation(int accountId, byte operationType, BigDecimal money,
            Timestamp operationDate) {
        this.accountId = accountId;
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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
                ", accountId=" + accountId +
                ", operationType=" + operationType +
                ", money=" + money +
                ", operationDate=" + operationDate +
                '}';
    }
}
