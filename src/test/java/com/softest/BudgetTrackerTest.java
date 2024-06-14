package com.softest;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BudgetTrackerTest {

    private BudgetTracker budgetTracker;

    @Before
    public void setUp() {
        budgetTracker = new BudgetTracker();
    }

    @Test
    public void testAddExpense() {
        budgetTracker.addExpense("Food", 10.5, "Lunch");
        List<Expense> expenses = budgetTracker.getExpenses();
        assertEquals(1, expenses.size());
        assertEquals("Food", expenses.get(0).getCategory());
        assertEquals(10.5, expenses.get(0).getAmount(), 0.01);
        assertEquals("Lunch", expenses.get(0).getDescription());
    }

    @Test
    public void testGetTotalExpenses() {
        budgetTracker.addExpense("Food", 10.5, "Lunch");
        budgetTracker.addExpense("Transport", 15.75, "Bus Ticket");
        assertEquals(26.25, budgetTracker.getTotalExpenses(), 0.01);
    }

    @Test
    public void testGetExpensesByCategory() {
        budgetTracker.addExpense("Food", 10.5, "Lunch");
        budgetTracker.addExpense("Transport", 15.75, "Bus Ticket");
        budgetTracker.addExpense("Food", 5.0, "Dinner");

        List<Expense> foodExpenses = budgetTracker.getExpensesByCategory("Food");
        assertEquals(2, foodExpenses.size());
        for (Expense expense : foodExpenses) {
            assertEquals("Food", expense.getCategory());
        }

        List<Expense> transportExpenses = budgetTracker.getExpensesByCategory("Transport");
        assertEquals(1, transportExpenses.size());
        assertEquals("Transport", transportExpenses.get(0).getCategory());
    }

    @Test
    public void testGetExpenses() {
        budgetTracker.addExpense("Food", 10.5, "Lunch");
        budgetTracker.addExpense("Transport", 15.75, "Bus Ticket");

        List<Expense> expenses = budgetTracker.getExpenses();
        assertNotNull(expenses);
        assertEquals(2, expenses.size());
    }

    @Test
    public void testGetExpenseByCategoryWhenNoExpenses() {
        List<Expense> expenses = budgetTracker.getExpensesByCategory("Food");
        assertTrue(expenses.isEmpty());
    }

    @Test
    public void testGetTotalExpensesWhenNoExpenses() {
        assertEquals(0.0, budgetTracker.getTotalExpenses(), 0.01);
    }

    @Test
    public void testAddExpenseWithZeroAmount() {
        budgetTracker.addExpense("Misc", 0.0, "Freebie");
        List<Expense> expenses = budgetTracker.getExpenses();
        assertEquals(1, expenses.size());
        assertEquals(0.0, expenses.get(0).getAmount(), 0.01);
    }

    @Test
    public void testAddExpenseWithNegativeAmount() {
        budgetTracker.addExpense("Misc", -10.0, "Penalty");
        List<Expense> expenses = budgetTracker.getExpenses();
        assertEquals(1, expenses.size());
        assertEquals(-10.0, expenses.get(0).getAmount(), 0.01);
    }

    @Test
    public void testGetExpensesByNonExistentCategory() {
        budgetTracker.addExpense("Food", 10.5, "Lunch");
        List<Expense> expenses = budgetTracker.getExpensesByCategory("NonExistentCategory");
        assertTrue(expenses.isEmpty());
    }
}
