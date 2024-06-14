package com.softest;
import java.util.ArrayList;
import java.util.List;

public class BudgetTracker {
    private List<Expense> expenses;

    public BudgetTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String category, double amount, String description) {
        expenses.add(new Expense(category, amount, description));
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public List<Expense> getExpensesByCategory(String category) {
        List<Expense> filteredExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                filteredExpenses.add(expense);
            }
        }
        return filteredExpenses;
    }
}
