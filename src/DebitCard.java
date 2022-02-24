import java.util.Date;

public class DebitCard {

    private double currBalance;
    private String cardNumber;
    private Date expDate; //expiration Date
    private int cvv;

    @Override
    public String toString() {
        return ("Current Balance: " + currBalance + "\nCard Number: " + cardNumber + "\nExpiration Date: " + expDate +
                "\nCVV: " + cvv);
    }

    public double getCurrBalance () {
        return currBalance;
    }
    public void setCarrBalance (double currBalance) {
        this.currBalance = currBalance;
    }

    public String getCardNumber () {
        return cardNumber;
    }
    public void setCardNumber (String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpDate () {
        return expDate;
    }
    public void setExpDate (Date expDate) {
        this.expDate = expDate;
    }

    public int getCvv () {
        return cvv;
    }
    public void setCvv (int cvv) {
        this.cvv = cvv;
    }
}
