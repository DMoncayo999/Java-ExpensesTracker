import java.text.SimpleDateFormat;
import java.util.Date;

// Class Expense with category, amount and date
public class Expense {
    private String category;
    private double amount;
    private Date date;

    //Constructor to initialize an Expense object
    public Expense(String category, double amount, Date date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
    // Getter method for category
    public String getCategory() {
        return category;
    }
    // Getter method for amount
    public double getAmount() {
        return amount;
    }
    //Getter method for date
    public Date getDate() {
        return date;
    }
    // Override toString method to provide a custom string representation for an Expense object
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("Category: %s, Amount: $%.2f, Date: %s", category, amount, dateFormat.format(date));
    }
}