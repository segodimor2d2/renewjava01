package app;

import entities.Account;
import entities.TransactionsHistory;

public class UI {
    public static void showMenu() {
        System.out.println("==================================================================================================================================================================================================================");

        System.out.println("MENU: \n"
                +"1-Create Account, "
                +"2-Balance, "
                +"3-Deposit, "
                +"4-Withdraw, "
                +"5-Change Limit, "
                +"6-Transfer, "
                +"7-Transactions History, "
                +"8-Save Transactions to CSV, "
                +"\n9-Show All Accounts, "
                +"10-Save All Accounts to CSV, "
                +"0-Exit Menu");

        System.out.println("==================================================================================================================================================================================================================");
        System.out.print("Option: ");
    }

    public static void showBalance(Account foundAccount) {
        if (foundAccount != null) {
            System.out.println(
                    "Status Balance => "
                            + "Name: " + foundAccount.getName()
                            + ", Account: " + foundAccount.getAccountNumber()
                            + ", Agency: " + foundAccount.getAgencyNumber()
                            + ", Type: " + foundAccount.getAccountType()
                            + ", Limit: " + foundAccount.getLimit()
                            + ", Amount: " + foundAccount.getAmount()
            );
        }
    }

    public static void showHistory(TransactionsHistory item) {
        if (item != null) {
            System.out.println(
                    "Account: " + item.getAccountNumber()
                            + ", Agency: " + item.getAgencyNumber()
                            + ", Type: " + item.getAccountType()
                            + ", Limit: " + item.getLimit()
                            + ", Name: " + item.getName()
                            + ", Amount: " + item.getAmount()
                            + ", Description: " + item.getDescription()
                            + ", DataTime: " + item.getTransactionTime()
            );
        }
    }
    public static void clear() {
        for (int i = 0; i < 20; ++i) System.out.println();
    }
}
