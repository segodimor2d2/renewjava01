package entities;

import java.time.LocalTime;
import java.util.List;

public class TransactionsHistory extends Account {
    private double limit;
    private String description;
    //public double limit;
    private LocalTime transactionTime;

    public TransactionsHistory(String accountNumber, String agencyNumber, String accountType, String name, double limit, double firstAmount, String description) {
        super(accountNumber, agencyNumber, accountType, name, firstAmount);
        this.limit = limit;
        this.description = description;
        this.transactionTime = LocalTime.now();
    }

    public TransactionsHistory(String accountNumber, String agencyNumber, String accountType, String name, double limit, double amount, String description, LocalTime transactionTime) {
        super(accountNumber, agencyNumber, accountType, name, amount);
        this.limit = limit;
        this.description = description;
        this.transactionTime = transactionTime;
    }

    public String getDescription() { return description; }
    public LocalTime getTransactionTime() { return transactionTime; }

}
