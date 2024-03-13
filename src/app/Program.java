package app;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("=====================================");

        /*
        System.out.print("Account: ");
        account.accountNumber = sc.nextInt();

        System.out.print("Agency: ");
        account.agencyNumber = sc.nextInt();

        System.out.print("Type Account, Current account(c) or Savings account(s): ");
        account.accountType = sc.next();

        System.out.print("Name: ");
        account.name = sc.next();

        System.out.print("Balance: ");
        account.balance = sc.nextDouble();

        System.out.println("=====================================");
        account.statement();
        */

        System.out.print("Is there an initial deposti (y/n)?: ");
        char res = sc.next().charAt(0);

        Account account;

        if (res == 'y') {
            System.out.println("=====================================");
            System.out.print("Initial deposit Value: ");
            double amount = sc.nextDouble();
            account = new Account(4488, 22, "s", "Tiago", amount);
            System.out.println("=====================================");
            account.statement();
            System.out.println("=====================================");
        }

        account = new Account(4488, 22, "s", "Tiago");
        System.out.println("=====================================");
        account.statement();
        System.out.println("=====================================");

        System.out.println("=====================================");
        sc.close();
    }
}
