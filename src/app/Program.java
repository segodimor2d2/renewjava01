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
        List<Account> accountList = fcsv.importFile(new ArrayList<>());

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
        Account accountData = null;
        Account accountDataPrayer = null;
        Account accountDataBenefy = null;
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

                // System.out.print("Transfer of Limit: ");
                // double limit = sc.nextDouble();

                System.out.print("Name: ");
                String name = sc.next();

                System.out.print("Initial Amount: ");
                double amount = sc.nextDouble();

                accountList.add(new Account(accountNumber, agencyNumber, accountType, name, amount));

                // Teste
                //account = new Account(4488, 22, "s", 1000, "Tiago", amount);
                //account = new Account(4488, 22, "s", 1000, "Tiago");

                accountData = foundAccount(accountList,accountNumber);
                UI.showBalance(accountData);

                break;

            case 2:
                System.out.println("SHOW BALANCE");

                // ID Target
                System.out.print("Enter the Account Number: ");
                targetId = new Scanner(System.in).next();
                accountData = foundAccount(accountList,targetId);
                UI.showBalance(accountData);
                break;

            case 3:
                System.out.println("DEPOSIT");

                // ID Target
                System.out.print("Enter the Account Number: ");
                targetId = new Scanner(System.in).next();

                accountData = foundAccount(accountList,targetId);
                if (accountData != null) {
                    UI.showBalance(accountData);

                    System.out.print("What is the deposit amount?: ");
                    amountChange = new Scanner(System.in).nextDouble();

                    accountData.deposit(amountChange);
                    UI.showBalance(accountData);
                }

                break;

            case 4:
                System.out.println("WITHDRAW");

                // ID Target
                System.out.print("Enter the Account Number: ");
                targetId = new Scanner(System.in).next();

                accountData = foundAccount(accountList,targetId);
                if (accountData != null) {
                    UI.showBalance(accountData);

                    System.out.print("What is the withdraw amount?: ");
                    amountChange = new Scanner(System.in).nextDouble();

                    accountData.withdraw(amountChange);
                    UI.showBalance(accountData);
                }

                break;
            case 5:
                System.out.println("CHANGE LIMIT");

                // ID Target
                System.out.print("Enter the Account Number: ");
                targetId = new Scanner(System.in).next();

                accountData = foundAccount(accountList,targetId);
                if (accountData != null) {
                    UI.showBalance(accountData);

                    System.out.print("What is the new Limit?: ");
                    amountChange = new Scanner(System.in).nextDouble();

                    accountData.changeLimit(amountChange);
                    UI.showBalance(accountData);

                }

                break;
            case 6:
                System.out.println("TRANSFER");

                // ID Target
                System.out.print("Enter the 'Payer' Account Number: ");
                String payerId = new Scanner(System.in).next();
                accountDataPrayer = foundAccount(accountList,payerId);

                if (accountDataPrayer != null) {
                    System.out.print("Enter the 'Beneficiary' Account Number: ");
                    String beneficaryId = new Scanner(System.in).next();
                    accountDataBenefy = foundAccount(accountList,beneficaryId);

                        if (accountDataBenefy != null) {

                            UI.showBalance(accountDataPrayer);
                            //UI.showBalance(accountDataBenefy);
                            System.out.print("What is the amount to transfer?: ");
                            amountChange = new Scanner(System.in).nextDouble();

                            accountDataPrayer.withdraw(amountChange);
                            accountDataBenefy.deposit(amountChange);
                            UI.showBalance(accountDataPrayer);
                            //UI.showBalance(accountDataBenefy);
                        }
                }

                break;
            case 8:
                System.out.println("SHOW ALL ACCOUNTS");
                for (Account item: accountList) {
                    UI.showBalance(item);
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

    private static Account foundAccount(List<Account> accountList, String targetId){
        Account foundAccount = null;
        int index = 0;
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
            //UI.showBalance(foundAccount);
            return foundAccount;
        } else {
            System.out.println("Error - The Account " + targetId + " is not found.");
            return foundAccount;
        }
    }
}


