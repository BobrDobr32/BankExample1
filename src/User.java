import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private String name;
    private String surname;
    private Date birthDate;
    private boolean gender;
    private String eMail;
    private String password;
    private ArrayList<Loan> loanList;
    private List<DebitCard> dbtCardList;

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

    public List<Loan> getLoanList() {
        return loanList;
    }
    public void setLoanList (ArrayList<Loan> loanList) {
        this.loanList = loanList;
    }

    public List<DebitCard> getDbtCardList() {
        return dbtCardList;
    }
    public void setDbtCardList(List<DebitCard> dbtCardList) {
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
        return ("Name: " + name + "\nSurname: " + surname + "\nBirth Date: " + birthDate + "\nGender: " + gender +
                "\nE-mail: " + eMail + "\nPassword: " + password + "\nLoans: " + loanList + "\nDebit Cards: " + dbtCardList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) return false;
        User us = (User) o;
        return eMail.equals(us.eMail);
    }

}

