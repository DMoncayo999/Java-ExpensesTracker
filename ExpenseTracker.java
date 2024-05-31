import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

// Class to represent the Expense Tracker application
public class ExpenseTracker {
    private ArrayList<Expense> expenses; // List to store all expenses
    private List<String> categories; // List of predefined categories

    // Constructor to initialize the ExpenseTracker
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

    // Method to add an expense to the tracker
    public void addExpense(String category, double amount) {
        Expense expense = new Expense(category, amount, new Date());
        expenses.add(expense);
    }

    // Method to display all expenses
    public void displayExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    // Method to calculate an return the total expenses
    public double getTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    // Method to display expenses by category
    public void displayExpensesByCategory() {
        HashMap<String, Double> categoryTotals = new HashMap<>();
        for (Expense expense : expenses) {
            // Add expense amount to the corresponding category total
            categoryTotals.put(expense.getCategory(),
                    categoryTotals.getOrDefault(expense.getCategory(), 0.0) + expense.getAmount());
        }
        // Print total expenses for each category
        for (String category : categoryTotals.keySet()) {
            System.out.println(category + ": $" + String.format("%.2f", categoryTotals.get(category)));
        }
    }

    // Method to display the menu options
    public void displayMenu() {
        System.out.println("\nExpense Tracker Menu:");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Display total expenses");
        System.out.println("4. Display expenses by category");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    // Method to display the available categories
    public void displayCategories() {
        System.out.println("Available categories:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
    }

    // Main method to run the Expense Tracker application
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Loop to keep displaying the menu until the user choose to exit
        while (choice !=5) {
            tracker.displayMenu();
            String input = scanner.nextLine();

            // Check if input is empty
            if (input.isEmpty()) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }  
            // Error handling: handle the NumberFormatException
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1: // Add an expense
                    tracker.displayCategories();
                    System.out.print("Select a category number:");
                    String categoryInput = scanner.nextLine();
                    int categoryChoice;

                    // Validate the category input
                    try {
                        categoryChoice = Integer.parseInt(categoryInput);
                        if (categoryChoice < 1 || categoryChoice > tracker.categories.size()) {
                            System.out.println("Invalid category choice.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid category choice. Please enter a valid number.");
                        break;
                    }

                    String category = tracker.categories.get(categoryChoice - 1);
                    System.out.println("Enter amount:");
                    String amountInput = scanner.nextLine();
                    double amount;

                    // Validate the amount input
                    try {
                        amount = Double.parseDouble(amountInput);
                    } catch (NumberFormatException e) {
                       System.out.println("Invalid amount. Please enter a valid number.");
                       break;
                    }
                    
                    tracker.addExpense(category, amount);
                    break;
                case 2: // Display all expenses
                    tracker.displayExpenses();
                    break;
                case 3: // Display total expenses
                    System.out.println("Total expenses: $" + tracker.getTotalExpenses());
                    break;
                case 4: // Display expenses by category
                    tracker.displayExpensesByCategory();
                    break;
                case 5: // Exit the application
                    System.out.println("Exiting...");
                    break;
                default: // Handle invalid menu choices
                    System.out.println("Invalid choice. Pleases try again.");
            }
        } 
        scanner.close();
    }
}
