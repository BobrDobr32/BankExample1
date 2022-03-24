import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BankMenu {

    private final Bank bank;
    private final User newUser = new User();

    private final Scanner sc = new Scanner(System.in);

    public void showStartMenu() {
        System.out.println ("Select one:\n1) Login\n2) Register\n3) Exit");
        int i = sc.nextInt();
        if (i == 1) showLogin();
        else if (i == 2) showRegister();
        else System.exit(0);
    }

    public BankMenu (Bank bank) {
        this.bank = bank;
    }

    public void showBankMenu() {
        if (bank.getCurrentUserName() == null) System.out.println ("Select one:\n1) Show my info\n2) Add Loan\n3) Add debit Card");
        else
            System.out.println ("Hello, " + bank.getCurrentUserName() + "! Select one:\n1) Show my info\n2) Add Loan\n3) Add debit Card");
    }

    private void showLogin() {
        System.out.println("Enter your e-mail:");
        newUser.setEMail(sc.next());
        System.out.println("Enter your Password:");
        newUser.setPassword(sc.next());
        if (bank.doLogin(newUser)) showBankMenu();
        else {
            System.out.println ("E-Mail or Password is wrong" );
            showStartMenu();
        }
    }

    private void showRegister() {

        System.out.println("Enter your Name:");
        newUser.setName(sc.next());

        System.out.println("Enter your Surname:");
        newUser.setSurname(sc.next());

        Date birthDate = null;

        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Enter your Date of Birth, format DD.MM.YYYY:");
        do {
        try {
            birthDate = date.parse(sc.next());
        }
        catch (Exception ex) {
            System.out.println("Enter your Date of Birth correctly (format DD.MM.YYYY)!");
        }
        } while (birthDate == null);
        newUser.setBirthDate(birthDate);

        System.out.println("Set your Gender:\n1) Male\n2) Female");
        newUser.setGender(sc.nextInt() == 1);

        System.out.println("Enter your E-mail:");
        newUser.setEMail(sc.next());

        System.out.println("Enter your Password:");
        newUser.setPassword(sc.next());

        bank.doRegister(newUser);
    }
    public void repeatEMail() {
        System.out.println ("This E-mail is occupied. Enter another E-Mail:");
        newUser.setEMail(sc.next());
        bank.doRegister(newUser);
    }


}
