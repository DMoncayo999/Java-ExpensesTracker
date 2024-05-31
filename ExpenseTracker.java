import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class ExpenseTracker {
    private ArrayList<Expense> expenses;
    private List<String> categories;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        categories = new ArrayList<>();

        // Add predefined categories
        categories.add("Food");
        categories.add("Transport");
        categories.add("Utilities");
        categories.add("Entertainment");
        categories.add("Miscellaneous");
    }

    public void addExpense(String category, double amount) {
        Expense expense = new Expense(category, amount, new Date());
        expenses.add(expense);
    }

    public void displayExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public double getTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    public void displayExpensesByCategory() {
        HashMap<String, Double> categoryTotals = new HashMap<>();
        for (Expense expense : expenses) {
            categoryTotals.put(expense.getCategory(),
                    categoryTotals.getOrDefault(expense.getCategory(), 0.0) + expense.getAmount());
        }
        for (String category : categoryTotals.keySet()) {
            System.out.println(category + ": $" + String.format("%.2f", categoryTotals.get(category)));
        }
    }

    public void displayMenu() {
        System.out.println("\nExpense Tracker Menu:");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Display total expenses");
        System.out.println("4. Display expenses by category");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    public void displayCategories() {
        System.out.println("Available categories:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            tracker.displayMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    tracker.displayCategories();
                    System.out.println("Select a category number:");
                    int categoryChoice = Integer.parseInt(scanner.nextLine());
                    if (categoryChoice < 1 || categoryChoice > tracker.categories.size()) {
                        System.out.println("Invalid category choice");
                        break;
                    }
                    String category = tracker.categories.get(categoryChoice - 1);
                    System.out.println("Enter amount:");
                    double ammount = Double.parseDouble(scanner.nextLine());
                    tracker.addExpense(category, ammount);
                    break;
                case 2:
                    tracker.displayExpenses();
                    break;
                case 3:
                    System.out.println("Total expenses: $" + tracker.getTotalExpenses());
                    break;
                case 4:
                    tracker.displayExpensesByCategory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Pleases try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
