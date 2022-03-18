import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BankMenu {

    private final Bank bank;

    Scanner sc = new Scanner (System.in);

    public void showStartMenu() {
        System.out.println ("Select one:\n1) Login\n2) Register\n3) Exit");
        int i = sc.nextInt();
        if (i == 1) showLogin();
        else if (i == 2) showRegister();
        else System.exit(0);
        sc.close();
    }

    public BankMenu (Bank bank) {
        this.bank = bank;
    }

    public void showBankMenu() {
        System.out.println ("Select one:\n1) Show my info\n2) Add Loan\n3) Add debit Card");
    }

    private void showLogin() {
        System.out.println("Enter your e-mail:");
        String e = sc.nextLine();
        System.out.println("Enter your Password:");
        String p = sc.nextLine();
        bank.doLogin(e, p);
    }

    private void showRegister() {
        User u = new User();
        System.out.println("Enter your Name:");
        String name = sc.nextLine();
        u.setName(name);
        System.out.println("Enter your Surname:");
        String surname = sc.nextLine();
        u.setSurname(surname);
        System.out.println("Enter your Year of Birth:");
        int year = sc.nextInt();
        System.out.println("Enter your Month of Birth (format: 1, 10, 12...etc:");
        int month = sc.nextInt();
        month = month - 1;
        System.out.println("Enter your Day of Birth:");
        int day = sc.nextInt();
        Calendar birthDate = new GregorianCalendar(year, month, day);
        u.setBirthDate(birthDate);
        System.out.println("Set your Gender:\n1) Male\n 2) Female");
        int g = sc.nextInt();
        boolean gender;
        if (g == 1) gender = true;
        else gender = false;
        u.setGender(gender);
        System.out.println("Enter your E-mail:");
        String eMail = sc.nextLine();
        u.setEMail(eMail);
        System.out.println("Enter your Password:");
        String password = sc.nextLine();
        u.setPassword(password);
        bank.doRegister(u);
    }


}
