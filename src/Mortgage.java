import java.io.Serializable;
import java.util.Date;

public class Mortgage extends Loan implements Serializable {
    private String type = "The best Mortgage";
    private final Date regDate = new Date();
    protected double amount = 100000.0;
    protected final double rate = 4.5;
    protected final int term = 120;
    protected final double payment = 1500;

    public Mortgage() {
       setType(type);
        setRegDate(regDate);
        setRate(rate);
        setTerm(term);
        setPayment(payment);
    }
}

