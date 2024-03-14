package app;

import entities.Account;
import filesInOut.FileCsv;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // import csv mock
        FileCsv fcsv = new FileCsv();

        //System.out.println("=====================================");
        List<Account> lst = fcsv.importFile();

        for (Account item: lst) {
            System.out.println(item.getName());
        }

        /*
        UI ui = new UI();
        boolean io = true;
        while (io) {
            UI.showMenu();
            int option = sc.nextInt();
            menuExecute(option);
            //ui.clear();
            if (option == 0){ io = false; };
        }*/

        sc.close();
    }

    /*
    private static void menuExecute(int option) {
        switch (option) {
            case 1:
                Locale.setDefault(Locale.US);
                Scanner sc = new Scanner(System.in);

                System.out.println();
                System.out.println("CREATE ACCOUNT.");

                System.out.print("Account: ");
                int accountNumber = sc.nextInt();

                System.out.print("Agency: ");
                int agencyNumber = sc.nextInt();

                System.out.print("Type Account, Current account(c) or Savings account(s): ");
                String accountType = sc.next();

                System.out.print("Name: ");
                String name = sc.next();

                System.out.print("Initial Amount: ");
                double balance = sc.nextDouble();

                //account = new Account(4488, 22, "s", "Tiago", amount);
                //account = new Account(4488, 22, "s", "Tiago");

                sc.close();
                break;

            case 2:
                System.out.println();
                System.out.println("Show Balance");
                break;
            case 3:
                System.out.println();
                System.out.println("Deposit");
                break;
            case 0:
                System.out.println();
                System.out.println("Exit, Goodbye!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
    */
}
