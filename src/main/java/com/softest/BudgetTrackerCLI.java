package com.softest;

import java.util.Scanner;

public class BudgetTrackerCLI {
    private static BudgetTracker budgetTracker = new BudgetTracker();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            clearScreen(); // Clear the screen before showing the menu
            System.out.println("Budget Tracker CLI");
            System.out.println("1. Add Expense");
            System.out.println("2. View Total Expenses");
            System.out.println("3. View All Expenses");
            System.out.println("4. View Expenses by Category");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addExpense();
                    waitForUser();
                    break;
                case 2:
                    viewTotalExpenses();
                    waitForUser();
                    break;
                case 3:
                    viewExpenses();
                    waitForUser();
                    break;
                case 4:
                    viewExpensesByCategory();
                    waitForUser();
                    break;
                case 5:
                    running = false;
                    clearScreen();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    waitForUser();
            }
        }
        scanner.close();
    }

    private static void addExpense() {
        System.out.println("Enter category:");
        String category = scanner.nextLine();
        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter description:");
        String description = scanner.nextLine();

        budgetTracker.addExpense(category, amount, description);
        System.out.println("Expense added successfully.");
    }

    private static void viewExpenses() {
        System.out.println("Expenses:");
        for (Expense expense : budgetTracker.getExpenses()) {
            System.out.println(expense.getCategory() + '|' + expense.getDescription() + ": $" + expense.getAmount());
        }
    }

    private static void viewTotalExpenses() {
        System.out.println("Total expenses: $" + budgetTracker.getTotalExpenses());
    }

    private static void viewExpensesByCategory() {
        System.out.println("Enter category:");
        String category = scanner.nextLine();
        for (Expense expense : budgetTracker.getExpensesByCategory(category)) {
            System.out.println(expense.getDescription() + ": $" + expense.getAmount());
        }
    }

    private static void waitForUser() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
        clearScreen();
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
