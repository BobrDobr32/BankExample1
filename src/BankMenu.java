import java.util.Scanner;

public class BankMenu {

    private Bank field;

    public void showStartMenu() {
        System.out.println ("Select one:\n1) Login\n2) Register\n3) Exit");
        Scanner sc = new Scanner (System.in);
        int i = sc.nextInt();
        if (i == 1) showLogin();
        else if (i == 2) showRegister();
        else System.exit(0);
        sc.close();
    }

    public void showBankMenu() {
        System.out.println ("Select one:\n1) Show my info\n2) Add Loan\n3) Add debit Card");
    }

    private void showLogin() {

    }

    private void showRegister() {

    }

}
