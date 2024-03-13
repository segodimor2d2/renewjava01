package entities;

public class Account {
    private int accountNumber;
    private int agencyNumber;
    private String accountType;
    private String name;
    private double balance;
    //public double limit;

    public Account(int accountNumber, int agencyNumber, String accountType, String name) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.accountType = accountType;
        this.name = name;
    }
    public Account(int accountNumber, int agencyNumber, String accountType, String name, double firstAmount) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.accountType = accountType;
        this.name = name;
        deposit(firstAmount);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getAgencyNumber() {
        return agencyNumber;
    }


    public String getAccountType() {
        return accountType;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        double old = balance;
        this.balance += amount;
        System.out.println("old balance: "
                +old
                +" | new balance: "
                +balance);
    }
    public void withdraw(double amount){
        double old = balance;
        this.balance -= amount;
        System.out.println("old balance: "
                +old
                +" | new balance: "
                +balance);
    }

    public void statement() {
        System.out.println( "Statment Account\n"+
                "accountNumber: " + accountNumber
                + " | "
                + "agencyNumber: " + agencyNumber
                + " | "
                + "accountType: " + accountType
                + " | "
                + "client: " + name
                + " | "
                + "balance: " + balance
        );
    }
}
