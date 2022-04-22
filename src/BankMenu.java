import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankMenu {

    private final Bank bank;
    private final User newUser = new User();

    private final Scanner sc = new Scanner(System.in);

    public void showStartMenu() {
        int i;
        System.out.println ("Select one:\n1) Login\n2) Register\n3) Exit from the program");
        while (true) {
            try {
                i = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Choose the Option (enter the correct Number):");
                sc.next();
                continue;
            }
            if (i == 1 || i == 2 || i ==3) {
                break;
            }
            System.out.println("Choose the Option (enter the correct Number):");
        }
        if (i == 1) showLogin();
        else if (i == 2) showRegister();
        System.exit(0);
    }

    public BankMenu (Bank bank) {
        this.bank = bank;
    }

    public void showBankMenu() {
        int i;
        User currentUser = bank.getCurrentUser();
        if (currentUser.getIsAdmin()) {
            System.out.println ("Hello, " + currentUser.getName() + "! Select one:\n1) Show my info\n2) Add Loan\n3) Add debit Card\n4) Show Statistics");
        }
        else
            System.out.println ("Hello, " + currentUser.getName() + "! Select one:\n1) Show my info\n2) Add Loan\n3) Add debit Card");
        while (true) {
            try {
                i = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Choose the Option (enter the correct Number):");
                continue;
            }
            if (((i > 0 && i <= 3) || (i == 4 && currentUser.getIsAdmin())))
                break;
            System.out.println("Choose the Option (enter the correct Number):");
        }
        if (i == 1) {
           System.out.println(currentUser);
           showBankMenu();
        }
        else if (i == 2)
            showLoanMenu();
        else if (i == 3)
            showCardMenu();
        bank.getStatistics();
    }

    public void showLoanMenu () {
        System.out.println("""
                Choose the Loan:
                
                1) The best Mortgage:
                Amount from 50000 $ to 100000$
                Interest Rate 4,5%
                Loan Term 120 months
                 Monthly payment 1500$
                 
                2) The best Car Loan:
                Amount from 5000$ to 20000$
                Interest Rate 9,5%
                Loan Term 36 months
                 Monthly payment 900$
                 
                """);
        int choice;
        double amount;
        while (true) {
            try {
                choice = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Choose the Option (enter the correct Number):");
                continue;
            }
            if (choice == 1 || choice == 2)
                break;
                System.out.println("Choose the Option (enter the correct Number):");
        }
        System.out.println ("Enter the wishful Amount:");
        while (true) {
            try {
                amount = sc.nextDouble();
            }
            catch (InputMismatchException e) {
                System.out.println("Input may contains the Digits only:");
                continue;
            }
            if ((choice == 2 && amount >= 5000 && amount <= 20000) || (choice == 1 && amount >= 50000 && amount <= 100000))
                break;
            System.out.println("Amount may be in specified Range for current Loan. Try the Input again");
        }
        bank.doAddLoan(choice, amount);
    }

    public void showCardMenu() {
        int choice;
        double currBalance;

        System.out.println("Do you want a debit Card?");
        while (true) {
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Choose the Option (enter the correct Number):");
                continue;
            }
            if (choice == 1 || choice == 2)
                break;
            System.out.println("Choose the Option (enter the correct Number):");
        }

        if (choice == 2) showBankMenu();


            System.out.println("Enter the Balance:");
        while (true) {
            try {
                currBalance = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Input may contains the Digits only:");
                continue;
            }
            break;
        }
        bank.addDebitCard(currBalance);
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
        catch (ParseException e) {
            System.out.println("Enter your Date of Birth correctly (format DD.MM.YYYY)!");
        }
        } while (birthDate == null);
        newUser.setBirthDate(birthDate);

        System.out.println("Set your Gender:\n1) Male\n2) Female");
            int i;
            while (true) {
                try {
                    i = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Set your gender correctly (enter the number 1 or 2):");
                    sc.next();
                    continue;
                }
                if (i == 1 || i == 2) {
                    newUser.setGender(i == 1);
                    break;
                }
                System.out.println("Set your gender correctly (enter the number 1 or 2):");
            }


        System.out.println("Enter your E-mail:");
        newUser.setEMail(sc.next());

        System.out.println("Enter your Password:");
        newUser.setPassword(sc.next());

        bank.doRegister(newUser);
    }
    public void repeatEMail() {
        System.out.println ("This E-mail is occupied. Enter another one:");
        newUser.setEMail(sc.next());
        bank.doRegister(newUser);
    }


}
