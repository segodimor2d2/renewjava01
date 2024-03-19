package entities;

import java.time.LocalTime;

public class Account {
    private String accountNumber;
    private String agencyNumber;
    private String accountType;
    private double limit;
    private String name;
    private double amount;
    //public double limit;

    public Account(String accountNumber, String agencyNumber, String accountType, String name) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.accountType = accountType;
        this.limit = 1000.0;
        this.name = name;
    }
    public Account(String accountNumber, String agencyNumber, String accountType, String name, double firstAmount) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.accountType = accountType;
        this.limit = 1000.0;
        this.name = name;
        deposit(firstAmount);
    }
    public Account(String accountNumber, String agencyNumber, String accountType, double limit, String name, double firstAmount) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.accountType = accountType;
        this.limit = 1000.0;
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

    public double getLimit() { return limit; }

    public double getAmount() { return amount; }

    public void deposit(double amount){
        double old = this.amount;
        this.amount += amount;
        //System.out.println("old balance: " +old +" | new balance: " + this.amount);
    }
    public void withdraw(double amountWithdraw){

        double limitRestriction = this.limit;

        //LocalTime currentTime = LocalTime.now();
        LocalTime currentTime  = LocalTime.of(23, 0); //test
        LocalTime deadlineTimeEarly= LocalTime.of(6, 0);
        LocalTime deadlineTimeNight = LocalTime.of(22, 0);

        if (!((currentTime.isAfter(deadlineTimeEarly) || currentTime.equals(deadlineTimeEarly)) && currentTime.isBefore(deadlineTimeNight))) {
            System.out.println("The limit restriction is active between 22:00h - 06:00h, limit restriction = 200");
            limitRestriction = 200.0;
        }

        double old = this.amount;
        if(amountWithdraw <= limitRestriction){
            this.amount -= amountWithdraw;
            //System.out.println("old balance: " +old +" | new balance: " + this.amount);
        }else{
            System.out.println("Error - the withdrawal must be less than equal to the limit, your limit is: "
                    +limitRestriction);
        }

    }
    public void changeLimit(double limit){
        if (limit >= 0) {
            double oldlimit = this.limit;
            this.limit = limit;
            //System.out.println("old limit: " +oldlimit +" | new limit: " + this.limit);
        }
        else {
            System.out.println("Error - the limit cannot be less than 0");
        }
    }

    public void statement() {
        System.out.println( "Statment Account\n"+
                "accountNumber: " + accountNumber
                + " | "
                + "agencyNumber: " + agencyNumber
                + " | "
                + "accountType: " + accountType
                + " | "
                + "limit: " + limit
                + " | "
                + "client: " + name
                + " | "
                + "balance: " + amount
        );
    }
}
