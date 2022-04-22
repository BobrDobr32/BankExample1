import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;


public class Bank {

    private final String FILE_NAME = "Users.dat";

    private User currentUser;

    private int currentUserIndex;

    private final BankMenu menu = new BankMenu(this);

    private ArrayList<User> users = new ArrayList<>();

    public List<User> getUsers(){
       return users;
   }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getCurrentUserName() {
       return currentUser.getName();
    }// Переписать!

    public void setBankLoanList(Object object) {
        Class finder = object.getClass();
        System.out.println(finder);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void serializeUsers (ArrayList<User> users) {
       try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            ous.writeObject(users);
        }
        catch (IOException ex) {
            System.out.println ("Error. Try to register again");
            menu.showStartMenu();
       }
    }

    public void deserializeUsers () {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
           users = (ArrayList<User>) ois.readObject();
        }
        catch (FileNotFoundException ex) {
            System.out.println ("Invalid Deserialization");
            File f = new File(FILE_NAME);
            try {
                if (!f.createNewFile())
                    System.out.println("Invalid File Creation");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException | IOException e) { //здесь предложила collapse catch
            e.printStackTrace();
        }
    }

    public boolean doLogin (User newUser) {
        for (User user : users) {
            if (user.equalsToLogin(newUser)) {
                currentUser = user;
                currentUserIndex = users.indexOf(user);
                return true;
            }
        }
        return false;
    }

    public void doRegister (User newUser) {
        LocalDateTime today = LocalDateTime.now();
        newUser.setRegDate(today);
        newUser.setLoanList(new ArrayList<>());
        newUser.setDbtCardList(new ArrayList<>());
        if (users.contains(newUser)) {
            menu.repeatEMail();
        }
        else {
            users.add(newUser);
            if (users.get(0).equals(newUser))
                newUser.setIsAdmin(true);
            serializeUsers(users);
            currentUser = newUser;
            menu.showBankMenu();
        }

    }

    public void doAddLoan(int choice, double amount) {
        ArrayList<Loan> currentLoanList = currentUser.getLoanList();
        Loan n;

        if (choice == 1) n = new Mortgage();
        else n = new CarLoan();
        n.setAmount(amount);
        currentLoanList.add(n);
        serializeUsers(users);
        menu.showBankMenu();
    }

    public void addDebitCard(double currBalance) {
        ArrayList<DebitCard> currentDbtCrdList = currentUser.getDbtCardList();
        DebitCard dbtCrd = new DebitCard();
        LocalDate today = LocalDate.now();

        dbtCrd.setCurrBalance(currBalance);
        dbtCrd.setExpDate(today.plusYears(4));
        dbtCrd.setCardNumber("4276080015933475");
        dbtCrd.setCvv(343);
        currentDbtCrdList.add(dbtCrd);
        serializeUsers(users);
        menu.showBankMenu();
    }

    public void getStatistics(){
        Integer packer = 1;
        System.out.println("1) Last Day registered Users:");
        List<User> lastDayUsers = users.stream().filter((user) -> user.getRegDate().isAfter(LocalDateTime.now().minusHours(24))).toList();
        System.out.println(lastDayUsers);
        System.out.println();
        System.out.println("2) Count of Loans sorting:");
        List<User> loansSortedUsers = users.stream().sorted((u1, u2) -> -u1.getLoanList().size()*packer.compareTo(u2.getLoanList().size())).toList();
        System.out.println(loansSortedUsers);
        System.out.println();
        System.out.println("3) Groping by count of debit Cards:");
        Map<Integer, List<User>> map = users.stream().collect(groupingBy(user -> user.getDbtCardList().size()));
        System.out.println(map);
    }

    public void start () {
       deserializeUsers();
       //System.out.println (users.size());
       menu.showStartMenu();
    }
}
