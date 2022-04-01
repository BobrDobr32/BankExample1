import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Bank implements Serializable {

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
                f.createNewFile();
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
        if (users.contains(newUser)) {
            menu.repeatEMail();
        }
        else {
            users.add(newUser);
            serializeUsers(users);
            currentUser = newUser;
            menu.showBankMenu();
        }

    }

    public void doAddLoan(int choice) {
        ArrayList<Loan> currentLoanList = (ArrayList<Loan>) currentUser.getLoanList();
        Loan n;

        if (choice == 1) n = new Mortgage();
        else n = new CarLoan();
        currentLoanList.add(n);
        currentUser.setLoanList(currentLoanList);
        users.set(currentUserIndex, currentUser);
        serializeUsers(users);
        menu.showBankMenu();
    }

    public void start () {
       deserializeUsers();
       System.out.println (users.size());
       menu.showStartMenu();
    }
}
