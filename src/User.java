import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private boolean isAdmin;
    private String name;
    private String surname;
    private Date birthDate;
    private boolean gender;
    private String eMail;
    private String password;
    private LocalDateTime regDate;
    private ArrayList<Loan> loanList;
    private ArrayList<DebitCard> dbtCardList;

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public boolean getIsAdmin() {return isAdmin;}
    public void setIsAdmin(boolean isAdmin) {this.isAdmin = isAdmin;}

    public String getName() {
       return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean getGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEMail() {
        return eMail;
    }
    public void setEMail (String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Loan> getLoanList() {
        return loanList;
    }
    public void setLoanList (ArrayList<Loan> loanList) {
        this.loanList = loanList;
    }

    public ArrayList<DebitCard> getDbtCardList() {
        return dbtCardList;
    }
    public void setDbtCardList(ArrayList<DebitCard> dbtCardList) {
        this.dbtCardList = dbtCardList;
    }

    public boolean equalsToLogin (Object o){
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) return false;
        User us = (User) o;
        return eMail.equals(us.eMail) && password.equals(us.password);
    }

    @Override
    public String toString() {
        return ("Name: " + name + "\nE-mail: " + eMail + "\nLoans: " + loanList.size() + "\nDebit Cards: " + dbtCardList.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) return false;
        User us = (User) o;
        return eMail.equals(us.eMail);
    }

}

