package com.softest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BudgetTrackerTest {
    private String category;
    private double amount;
    private String description;

    private BudgetTracker budgetTracker;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Food", 10.50, "Lunch" },
                { "Transport", 15.75, "Bus Ticket" },
                { "Food", 20.00, "Dinner" },
                { "Entertainment", 30.00, "Movie" }
        });
    }

    public BudgetTrackerTest(String category, double amount, String description) {
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    @Before
    public void setUp() {
        budgetTracker = new BudgetTracker();
    }

    @Test
    public void testAddExpense() {
        budgetTracker.addExpense(category, amount, description);
        List<Expense> expenses = budgetTracker.getExpenses();
        assertEquals(1, expenses.size());
        Expense expense = expenses.get(0);
        assertEquals(category, expense.getCategory());
        assertEquals(amount, expense.getAmount(), 0.01);
        assertEquals(description, expense.getDescription());
    }

    @Test
    public void testGetExpenses() {
        budgetTracker.addExpense("Food", 10.50, "Lunch");
        budgetTracker.addExpense("Transport", 15.75, "Bus Ticket");

        List<Expense> expenses = budgetTracker.getExpenses();
        assertEquals(2, expenses.size());
    }

    @Test
    public void testGetTotalExpenses() {
        budgetTracker.addExpense("Food", 10.50, "Lunch");
        budgetTracker.addExpense("Transport", 15.75, "Bus Ticket");

        double total = budgetTracker.getTotalExpenses();
        assertEquals(26.25, total, 0.01);
    }

    @Test
    public void testEmptyExpenses() {
        List<Expense> expenses = budgetTracker.getExpenses();
        assertTrue(expenses.isEmpty());

        double total = budgetTracker.getTotalExpenses();
        assertEquals(0.0, total, 0.01);
    }
}
