import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Bank implements Serializable {

    private User currentUser;

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
    }

    public void serializeUsers (ArrayList<User> users) {
       try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("Users.dat"))){
            ous.writeObject(users);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println ("Error. Try to register again");
            menu.showStartMenu();
       }

    }

    public void deserializeUsers () {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Users.dat"))) {
            users = (ArrayList<User>) ois.readObject();
        }
        catch (Exception ex) {
            System.out.println ("Invalid Deserialization");
        }
    }

    public boolean doLogin (User newUser) {
        for (User user : users) {
            if (user.equalsToLogin(newUser)) {
                currentUser = user;
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

    public void start () {
       deserializeUsers();
       System.out.println (users.size());
       menu.showStartMenu();
    }
}
