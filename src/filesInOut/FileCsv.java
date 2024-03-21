package filesInOut;

import entities.Account;
import entities.TransactionsHistory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCsv {
    public List<Account> importFile(List<Account> accountList, List<TransactionsHistory> transactionsHistoryList) {

        String sourceFileStr = "mockAccount01.csv";
        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
            String itemCsv = br.readLine();
            itemCsv = br.readLine(); // pula os cavesalhos
            while (itemCsv != null) {
                String[] fields = itemCsv.split(",");
                String accountNumber = fields[0];
                String agencyNumber = fields[1];
                String accountType = fields[2];
                double limit = Double.parseDouble(fields[3]);
                String name = fields[4];
                double amount = Double.parseDouble(fields[5]);

                accountList.add(new Account(accountNumber, agencyNumber, accountType, limit, name, amount));
                //transactionsHistoryList.add(new TransactionsHistory(accountNumber, agencyNumber, accountType, limit, amount, I"createAccount"));
                transactionsHistoryList.add(new TransactionsHistory(accountNumber, agencyNumber, accountType, name, limit, amount, "createAccount"));
                itemCsv = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error in read: " + e.getMessage());
        }
        return accountList;
    }
    public void exportHistory(List<TransactionsHistory> transactionsHistoryList){
        String targetFlieStr = "transactionHistory.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFlieStr))) {
            bw.write("accountNumber,agencyNumber,accountType,limit,name,amount,transactionTime");
            bw.newLine();
            for (TransactionsHistory item: transactionsHistoryList) {
                bw.write(item.getAccountNumber()
                        +","
                        +item.getAgencyNumber()
                        +","
                        +item.getAccountType()
                        +","
                        +item.getLimit()
                        +","
                        +item.getName()
                        +","
                        +item.getAmount()
                        +","
                        +item.getDescription()
                        +","
                        +item.getTransactionTime() );
                bw.newLine();
            }

            System.out.println(targetFlieStr + " created");

        } catch (IOException e){
            System.out.println("error in write: "+ e.getMessage());
        }
    }
    public void exportFile(List<Account> accountList){
        String targetFlieStr = "mockAccount02.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFlieStr))) {
            bw.write("accountNumber,agencyNumber,accountType,limit,name,amount");
            bw.newLine();
            for (Account item: accountList) {
                bw.write(item.getAccountNumber()
                        +","
                        +item.getAgencyNumber()
                        +","
                        +item.getAccountType()
                        +","
                        +item.getLimit()
                        +","
                        +item.getName()
                        +","
                        +item.getAmount() );
                bw.newLine();
            }

            System.out.println(targetFlieStr + " created");

        } catch (IOException e){
            System.out.println("error in write: "+ e.getMessage());
        }
    }
}
