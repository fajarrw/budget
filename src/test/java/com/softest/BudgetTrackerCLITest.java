package com.softest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class BudgetTrackerCLITest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // @Test
    // public void testAddExpense() {
    // String simulatedInput = "1\nFood\n10.5\nLunch\n\n5\n";
    // provideSimulatedInput(simulatedInput);

    // BudgetTrackerCLI.main(new String[] {});

    // String expectedOutput = "Budget Tracker CLI\n" +
    // "1. Add Expense\n" +
    // "2. View Total Expenses\n" +
    // "3. View All Expenses\n" +
    // "4. View Expenses by Category\n" +
    // "5. Exit\n" +
    // "Choose an option: Enter category:\n" +
    // "Enter amount:\n" +
    // "Enter description:\n" +
    // "Expense added successfully.\n" +
    // "Press Enter to continue...";

    // assertTrue(outContent.toString().contains(expectedOutput));
    // }

    // @Test
    // public void testViewTotalExpenses() {
    // // Prepare test data
    // BudgetTracker budgetTracker = new BudgetTracker();
    // budgetTracker.addExpense("Food", 10.5, "Lunch");
    // budgetTracker.addExpense("Transport", 15.75, "Bus Ticket");

    // // Simulate input for option 2
    // String simulatedInput = "2\n\n5\n";
    // provideSimulatedInput(simulatedInput);

    // // Run CLI
    // BudgetTrackerCLI.main(new String[] {});

    // // Verify output
    // String expectedOutput = "Budget Tracker CLI\n" +
    // "1. Add Expense\n" +
    // "2. View Total Expenses\n" +
    // "3. View All Expenses\n" +
    // "4. View Expenses by Category\n" +
    // "5. Exit\n" +
    // "Choose an option: Total expenses: $26.25\n" +
    // "Press Enter to continue...";

    // assertTrue(outContent.toString().contains(expectedOutput));
    // }

    // @Test
    // public void testViewExpenses() {
    // // Prepare test data
    // BudgetTracker budgetTracker = new BudgetTracker();
    // budgetTracker.addExpense("Food", 10.5, "Lunch");
    // budgetTracker.addExpense("Transport", 15.75, "Bus Ticket");

    // // Simulate input for option 3
    // String simulatedInput = "3\n\n5\n";
    // provideSimulatedInput(simulatedInput);

    // // Run CLI
    // BudgetTrackerCLI.main(new String[] {});

    // // Verify output
    // String expectedOutput = "Budget Tracker CLI\n" +
    // "1. Add Expense\n" +
    // "2. View Total Expenses\n" +
    // "3. View All Expenses\n" +
    // "4. View Expenses by Category\n" +
    // "5. Exit\n" +
    // "Choose an option: Expenses:\n" +
    // "Food|Lunch: $10.5\n" +
    // "Transport|Bus Ticket: $15.75\n" +
    // "Press Enter to continue...";

    // assertTrue(outContent.toString().contains(expectedOutput));
    // }

    // @Test
    // public void testViewExpensesByCategory() {
    // // Prepare test data
    // BudgetTracker budgetTracker = new BudgetTracker();
    // budgetTracker.addExpense("Food", 10.5, "Lunch");
    // budgetTracker.addExpense("Transport", 15.75, "Bus Ticket");

    // // Simulate input for option 4
    // String simulatedInput = "4\nFood\n\n5\n";
    // provideSimulatedInput(simulatedInput);

    // // Run CLI
    // BudgetTrackerCLI.main(new String[] {});

    // // Verify output
    // String expectedOutput = "Budget Tracker CLI\n" +
    // "1. Add Expense\n" +
    // "2. View Total Expenses\n" +
    // "3. View All Expenses\n" +
    // "4. View Expenses by Category\n" +
    // "5. Exit\n" +
    // "Choose an option: Enter category:\n" +
    // "Lunch: $10.5\n" +
    // "Press Enter to continue...";

    // assertTrue(outContent.toString().contains(expectedOutput));
    // }

    // @Test
    // public void testInvalidOption() {
    // String simulatedInput = "9\n\n5\n";
    // provideSimulatedInput(simulatedInput);

    // BudgetTrackerCLI.main(new String[] {});

    // String expectedOutput = "Budget Tracker CLI\n" +
    // "1. Add Expense\n" +
    // "2. View Total Expenses\n" +
    // "3. View All Expenses\n" +
    // "4. View Expenses by Category\n" +
    // "5. Exit\n" +
    // "Choose an option: Invalid option. Please try again.\n" +
    // "Press Enter to continue...";

    // assertTrue(outContent.toString().contains(expectedOutput));
    // }

    private void provideSimulatedInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    private String getLastOutput() {
        String[] outputs = outContent.toString().split("Press Enter to continue...");
        return outputs[outputs.length - 1].trim();
    }
}
