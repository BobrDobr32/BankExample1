import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bank implements Serializable {

    private final BankMenu menu = new BankMenu(this);

    public List<User> users = new ArrayList<>();

   public List<User> getUsers(){
       return users;
   }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void serializeUsers (List<User> users) throws IOException {
        //FileOutputStream outputStream = new FileOutputStream("F:\\Prog\\Week7\\Banking Example\\src\\Users.dat");
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("Users.dat"));
        ous.writeObject(users);
        ous.close();
    }

    public void deserializeUsers (List<User> users) throws IOException, ClassNotFoundException {
        //FileOutputStream outputStream = new FileOutputStream("F:\\Prog\\Week7\\Banking Example\\src\\Users.dat");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Users.dat"));
        List<User> users1 = ((List<User>) ois.readObject());
        ois.close();
    }

    public boolean doLogin (String eMail, String password) {
        return true;
    }

    public void doRegister (User user) {
        users.add(user);
    }


    public void start () {
        menu.showStartMenu();
    }
}
