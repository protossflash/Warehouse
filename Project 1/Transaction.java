import java.math.BigDecimal;
import java.util.Date;

public class Transaction
{
    private Date transactionDate;
    private String description;
    private BigDecimal dollarAmount;

    public Transaction(Date transactionDate, String description, BigDecimal dollarAmount)
    {
        this.transactionDate = transactionDate;
        this.description = description;
        this.dollarAmount = dollarAmount;
    }

    public String toString()
    {
        String string = "Transaction Date: " + transactionDate + " Description:  " + description + " Dollar Amount: $" + dollarAmount;
        return string;
    }

}