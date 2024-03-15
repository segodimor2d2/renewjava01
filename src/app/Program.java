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

        // IMPORT CSV MOCK
        FileCsv fcsv = new FileCsv();
        List<Account> accountList = fcsv.importFile();
        //for (Account item: accountList) { System.out.println(item.getName()); }

        // MENU
        Scanner scMenu = new Scanner(System.in);
        UI ui = new UI();
        boolean io = true;
        while (io) {
            System.out.println();
            UI.showMenu();
            int option = scMenu.nextInt();
            System.out.println();
            menuExecute(option, accountList);
            //ui.clear();
            if (option == 0){ io = false; };
        }
        scMenu.close();
    }

    private static void menuExecute(int option, List<Account> accountList) {
        String targetId;
        int index = 0;
        double amountChange;
        Account foundAccount = null;
        switch (option) {

            case 1:
                Locale.setDefault(Locale.US);
                Scanner sc = new Scanner(System.in);

                System.out.println();
                System.out.println("CREATE ACCOUNT.");

                System.out.print("Account: ");
                String accountNumber = sc.next();

                System.out.print("Agency: ");
                String agencyNumber = sc.next();

                System.out.print("Type Account, Current account(c) or Savings account(s): ");
                String accountType = sc.next();

                System.out.print("Name: ");
                String name = sc.next();

                System.out.print("Initial Amount: ");
                double amount = sc.nextDouble();

                accountList.add(new Account(accountNumber, agencyNumber, accountType, name, amount));
                //account = new Account(4488, 22, "s", "Tiago", amount);
                //account = new Account(4488, 22, "s", "Tiago");
                break;

            case 2:
                System.out.println("SHOW BALANCE");

                // ID Target
                System.out.print("Enter the Account Number: ");
                targetId = new Scanner(System.in).next();

                for (Account item: accountList) {
                    // System.out.println(item.getAccountNumber()+" "+targetId +" "+item.getAccountNumber().getClass().getSimpleName() +" "+targetId.getClass().getSimpleName() +" "+item.getAccountNumber().length() +" "+targetId.length() );
                    if (item.getAccountNumber().equals(targetId)) {
                        foundAccount = item;
                        break;
                    }
                    index += 1;
                }

                if (foundAccount != null) {
                    //System.out.println("Conta encontrada: " + foundAccount);
                    System.out.println(
                        "Name: "+foundAccount.getName()
                        +", Account: "+foundAccount.getAccountNumber()
                        +", Agency: "+foundAccount.getAgencyNumber()
                        +", Type: "+foundAccount.getAccountType()
                        +", Amount: "+foundAccount.getAmount()
                    );
                } else {
                    System.out.println("The Account " + targetId + " is not found.");
                }
                break;

            case 3:
                System.out.println("DEPOSIT");

                // ID Target
                System.out.print("Enter the Account Number: ");
                targetId = new Scanner(System.in).next();

                for (Account item: accountList) {
                    // System.out.println(item.getAccountNumber()+" "+targetId +" "+item.getAccountNumber().getClass().getSimpleName() +" "+targetId.getClass().getSimpleName() +" "+item.getAccountNumber().length() +" "+targetId.length() );
                    if (item.getAccountNumber().equals(targetId)) {
                        foundAccount = item;
                        break;
                    }
                    index += 1;
                }

                if (foundAccount != null) {
                    System.out.print("What is the deposit amount?: ");
                    amountChange = new Scanner(System.in).nextDouble();

                    foundAccount.deposit(amountChange);

                    System.out.println(
                            "Name: "+foundAccount.getName()
                                    +", Account: "+foundAccount.getAccountNumber()
                                    +", Agency: "+foundAccount.getAgencyNumber()
                                    +", Type: "+foundAccount.getAccountType()
                                    +", Amount: "+foundAccount.getAmount()
                    );
                } else {
                    System.out.println("The Account " + targetId + " is not found.");
                }
                break;

            case 4:
                System.out.println("WITHDRAW");

                // ID Target
                System.out.print("Enter the Account Number: ");
                targetId = new Scanner(System.in).next();

                for (Account item: accountList) {
                    // System.out.println(item.getAccountNumber()+" "+targetId +" "+item.getAccountNumber().getClass().getSimpleName() +" "+targetId.getClass().getSimpleName() +" "+item.getAccountNumber().length() +" "+targetId.length() );
                    if (item.getAccountNumber().equals(targetId)) {
                        foundAccount = item;
                        break;
                    }
                    index += 1;
                }

                if (foundAccount != null) {
                    System.out.print("What is the withdraw amount?: ");
                    amountChange = new Scanner(System.in).nextDouble();

                    foundAccount.withdraw(amountChange);

                    System.out.println(
                            "Name: "+foundAccount.getName()
                                    +", Account: "+foundAccount.getAccountNumber()
                                    +", Agency: "+foundAccount.getAgencyNumber()
                                    +", Type: "+foundAccount.getAccountType()
                                    +", Amount: "+foundAccount.getAmount()
                    );
                } else {
                    System.out.println("The Account " + targetId + " is not found.");
                }
                break;

            case 8:
                System.out.println("SHOW ALL ACCOUNTS");
                for (Account item: accountList) {
                    System.out.println(
                        "Name: "+item.getName()
                        +", Account: "+item.getAccountNumber()
                        +", Agency: "+item.getAgencyNumber()
                        +", Type: "+item.getAccountType()
                        +", Amount: "+item.getAmount()
                    );
                }
                break;

            case 9:
                System.out.println("SAVE ALL ACCOUNTS TO CSV");
                FileCsv fcsv = new FileCsv();
                fcsv.exportFile(accountList);
                break;

            case 0:
                System.out.println("Exit, Goodbye!");
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
