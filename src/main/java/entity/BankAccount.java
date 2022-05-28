package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "bankaccount")
@NamedQueries(
        @NamedQuery(name = "BankAccount.findAll", query = "SELECT b FROM BankAccount b")
)
public class BankAccount extends ActiveBankAccount implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "amount")
    private Double amount;

    public BankAccount() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return
                "accountNumber='" + accountNumber + '\'' +
                        ", amount=" + amount
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;

        return accountNumber != null ? accountNumber.equals(that.accountNumber) : that.accountNumber == null;
    }

    @Override
    public int hashCode() {
        return accountNumber != null ? accountNumber.hashCode() : 0;
    }
}
