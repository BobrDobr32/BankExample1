import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class DebitCard implements Serializable {

    private double currBalance;
    private String cardNumber;
    private LocalDate expDate; //expiration Date
    private int cvv;

    @Override
    public String toString() {
        return ("Current Balance: " + currBalance + "\nCard Number: " + cardNumber + "\nExpiration Date: " + expDate +
                "\nCVV: " + cvv);
    }

    public double getCurrBalance () {
        return currBalance;
    }
    public void setCurrBalance (double currBalance) {
        this.currBalance = currBalance;
    }

    public String getCardNumber () {
        return cardNumber;
    }
    public void setCardNumber (String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpDate () {
        return expDate;
    }
    public void setExpDate (LocalDate expDate) {
        this.expDate = expDate;
    }

    public int getCvv () {
        return cvv;
    }
    public void setCvv (int cvv) {
        this.cvv = cvv;
    }
}
