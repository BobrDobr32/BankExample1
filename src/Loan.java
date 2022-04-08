import java.util.Date;

public abstract class Loan {

    protected String type;
    private Date regDate;
    private double amount;
    private double rate; //interest Rate
    private int term; //Loan Term
    private double payment; //Monthly Payment

    @Override
    public String toString () {
        return ("\nType " + type + "\nRegistration Date: " + regDate + "\nAmount: " + amount + "\nInterest Rate: " + rate + "\nTerm: " + term
        + "\nMonthly Payment: " + payment);
    }

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public Date getRegDate () {
        return regDate;
    }
    public void setRegDate (Date regDate) {
        this.regDate = regDate;
    }

    public double getAmount () {
        return amount;
    }
    public void setAmount (double amount) {
        this.amount = amount;
    }

    public double getRate () {
        return rate;
    }
    public void setRate (double rate) {
        this.rate = rate;
    }

    public int getTerm () {
        return term;
    }
    public void setTerm (int term) {
        this.term = term;
    }

    public double getPayment () {
        return payment;
    }
    public void setPayment (double payment) {
        this.payment = payment;
    }
}
