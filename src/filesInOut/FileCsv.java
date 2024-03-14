package filesInOut;

import entities.Account;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCsv {
    public List<Account> importFile() {
        List<Account> lst = new ArrayList<>();

        //List<Account> list = new ArrayList<>();

        //String sourceFileStr = "../mockAccount01.csv";
        String sourceFileStr = "mockAccount01.csv";

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        //System.out.println(sourceFolderStr);

        //File success = new File(sourceFolderStr + "\\out");
        //System.out.println(success);

        //String targetFlieStr = sourceFolderStr + "fileout.csv";


        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
            String itemCsv = br.readLine();
            itemCsv = br.readLine(); // pula os cavesalhos
            while (itemCsv != null) {
                String[] fields = itemCsv.split(",");
                String accountNumber = fields[0];
                String agencyNumber = fields[1];
                String accountType = fields[2];
                String name = fields[3];
                double amount = Double.parseDouble(fields[4]);

                lst.add(new Account(accountNumber, agencyNumber, accountType, name, amount));
                itemCsv = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("error in read: " + e.getMessage());
        }

        return lst;
    }
    public void exportFile(List<Account> lst){
        String targetFlieStr = "mockAccount02.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFlieStr))) {
            bw.write("accountNumber,agencyNumber,accountType,name,amount");
            bw.newLine();
            for (Account item: lst) {
                bw.write(item.getAccountNumber()
                        +","
                        +item.getAgencyNumber()
                        +","
                        +item.getAccountType()
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
