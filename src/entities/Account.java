package entities;

public class Account {
    private String accountNumber;
    private String agencyNumber;
    private String accountType;
    private String name;
    private double amount;
    //public double limit;

    public Account(String accountNumber, String agencyNumber, String accountType, String name) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.accountType = accountType;
        this.name = name;
    }
    public Account(String accountNumber, String agencyNumber, String accountType, String name, double firstAmount) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.accountType = accountType;
        this.name = name;
        deposit(firstAmount);
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

    public double getAmount() {
        return amount;
    }

    public void deposit(double amount){
        double old = this.amount;
        this.amount += amount;
        System.out.println("old balance: "
                +old
                +" | new balance: "
                + this.amount);
    }
    public void withdraw(double amount){
        double old = this.amount;
        this.amount -= amount;
        System.out.println("old balance: "
                +old
                +" | new balance: "
                + this.amount);
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
                + "balance: " + amount
        );
    }
}
