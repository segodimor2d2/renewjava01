package app;

import entities.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================");

        List<Account> list = new ArrayList<>();

        //String sourceFileStr = "../mockAccount01.csv";
        String sourceFileStr = "mockAccount01.csv";

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        //System.out.println(sourceFolderStr);

        //File success = new File(sourceFolderStr + "\\out");
        //System.out.println(success);

        //String targetFlieStr = sourceFolderStr + "fileout.csv";
        String targetFlieStr = "mockAccount02.csv";


        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
            String itemCsv = br.readLine();
            itemCsv = br.readLine(); // pula os cavesalhos
            while (itemCsv != null){
                String[] fields = itemCsv.split(",");
                String accountNumber = fields[0];
                String agencyNumber = fields[1];
                String accountType = fields[2];
                String name = fields[3];
                double amount = Double.parseDouble(fields[4]);

                list.add(new Account(accountNumber,agencyNumber,accountType,name,amount));
                itemCsv = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFlieStr))) {
                bw.write("accountNumber,agencyNumber,accountType,name,amount");
                bw.newLine();
                for (Account item: list) {
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

        } catch (IOException e){
            System.out.println("error in read: "+ e.getMessage());
        }





        System.out.println("=====================================");



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
