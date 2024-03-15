package app;

public class UI {
    public static void showMenu() {
        System.out.println("===============================================================================================================");
        //System.out.println("MENU:");
        //System.out.println("1 Create Account");
        //System.out.println("2 Show Balance");
        //System.out.println("3 Deposit");
        //System.out.println("0 Exit Menu");

        System.out.println("MENU: , 1-Create Account, 2-Show Account Balance, 4-Deposit, 5-Show All Accounts, 6-Sava to CSV,  0-Exit Menu");
        System.out.println("===============================================================================================================");
        System.out.print("Option: ");
    }
    public static void clear() {
        // Imprime 50 novas linhas
        //for (int i = 0; i < 50; ++i) System.out.println();
        for (int i = 0; i < 20; ++i) System.out.println();
    }
}
