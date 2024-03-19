package entities;

import java.time.LocalTime;

public class TransactionsHistory {
    private String accountNumber;
    private String agencyNumber;
    private String accountType;
    private double limit;
    private String name;
    private double amount;
    private String description;
    //public double limit;
    private LocalTime transactionTime;

    public TransactionsHistory(String accountNumber, String agencyNumber, String accountType, double limit, String name, double amount, String description) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.accountType = accountType;
        this.limit = limit;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.transactionTime = LocalTime.now();
    }
    public TransactionsHistory(String accountNumber, String agencyNumber, String accountType, double limit, String name, double amount, String description, LocalTime transactionTime) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.accountType = accountType;
        this.limit = limit;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.transactionTime = transactionTime;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getName() {
        return name;
    }

    public double getLimit() { return limit; }

    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public LocalTime getTransactionTime() { return transactionTime; }

}
