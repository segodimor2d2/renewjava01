package app;

import entities.Account;
import entities.TransactionsHistory;
import filesInOut.FileCsv;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        // IMPORT CSV MOCK
        FileCsv fcsv = new FileCsv();
        List<TransactionsHistory> transactionsHistoryList = new ArrayList<>();
        List<Account> accountList = fcsv.importFile(new ArrayList<>(), transactionsHistoryList);
        //for(TransactionsHistory itemHistory: transactionsHistoryList){ UI.showHistory(itemHistory); }

        // MENU
        Scanner scMenu = new Scanner(System.in);
        UI ui = new UI();
        boolean io = true;
        while (io) {
            System.out.println();
            UI.showMenu();
            int option = scMenu.nextInt();
            System.out.println();
            menuExecute(option, accountList, transactionsHistoryList);
            //ui.clear();
            if (option == 0){ io = false; };
        }
        scMenu.close();
    }

    private static void menuExecute(int option, List<Account> accountList, List<TransactionsHistory> transactionsHistoryList) {
        String targetId;
        int index = 0;
        double amountChange;
        Account accountData = null;
        Account accountDataPrayer = null;
        Account accountDataBenefy = null;
        FileCsv fcsv = new FileCsv();
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
                setTransactionsHistory(accountData,transactionsHistoryList,"createAccount");



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
                    setTransactionsHistory(accountData,transactionsHistoryList,"deposit");
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
                    setTransactionsHistory(accountData,transactionsHistoryList, "withdraw");
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
                    setTransactionsHistory(accountData,transactionsHistoryList, "changeLimit");
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
                            setTransactionsHistory(accountDataPrayer,transactionsHistoryList, "withdraw");

                            accountDataBenefy.deposit(amountChange);
                            setTransactionsHistory(accountDataBenefy,transactionsHistoryList, "deposit");

                            UI.showBalance(accountDataPrayer);
                            //UI.showBalance(accountDataBenefy);
                        }
                }

                break;
            case 7:
                System.out.println("TRANSACTION HISTORY");

                // ID Target
                System.out.print("Enter the Account Number: ");
                targetId = new Scanner(System.in).next();
                foundHistory(transactionsHistoryList,targetId,false);

                break;
            case 8:
                fcsv = new FileCsv();
                System.out.println("SAVE TRANSACTION HISTORY TO CSV");

                // ID Target
                System.out.print("Enter the Account Number: ");
                targetId = new Scanner(System.in).next();
                foundHistory(transactionsHistoryList,targetId,true);

                break;
            case 9:
                System.out.println("SHOW ALL ACCOUNTS");
                for (Account item: accountList) {
                    UI.showBalance(item);
                }

                break;
            case 10:
                System.out.println("SAVE ALL ACCOUNTS TO CSV");
                fcsv.exportFile(accountList);

                break;
            case 0:
                System.out.println("Exit, Goodbye!");

                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void foundHistory(List<TransactionsHistory> transactionsHistoryList, String targetId, boolean flagCsv){
        FileCsv fcsv = new FileCsv();
        List<TransactionsHistory> filteredList = new ArrayList<>();
        for(TransactionsHistory itemHistory: transactionsHistoryList){
            if(itemHistory.getAccountNumber().equals(targetId)){
                UI.showHistory(itemHistory);
                filteredList.add(itemHistory);
            }
        }

        if (flagCsv){
            fcsv.exportHistory(filteredList);
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
    public static void setTransactionsHistory(Account accountData, List<TransactionsHistory> transactionsHistoryList, String description) {
        transactionsHistoryList.add(new TransactionsHistory(
                accountData.getAccountNumber(),
                accountData.getAgencyNumber(),
                accountData.getAccountType(),
                accountData.getName(),
                accountData.getLimit(),
                accountData.getAmount(),
                description,
                LocalTime.now()
        ));
    }
}


