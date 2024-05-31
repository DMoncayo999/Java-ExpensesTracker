import java.text.SimpleDateFormat;
import java.util.Date;

public class Expense {
    private String category;
    private double amount;
    private Date date;

    public Expense(String category, double amount, Date date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return String.format("Category: %s, Amount: $%.2f, Date: %s", category, amount, dateFormat.format(date));
    }
}