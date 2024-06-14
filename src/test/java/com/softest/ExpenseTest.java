package com.softest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpenseTest {

    @Test
    public void testExpenseConstructorAndGetters() {
        Expense expense = new Expense("Food", 10.5, "Lunch");
        assertEquals("Food", expense.getCategory());
        assertEquals(10.5, expense.getAmount(), 0.01);
        assertEquals("Lunch", expense.getDescription());
    }

    @Test
    public void testSetCategory() {
        Expense expense = new Expense("Food", 10.5, "Lunch");
        expense.setCategory("Transport");
        assertEquals("Transport", expense.getCategory());
    }

    @Test
    public void testSetAmount() {
        Expense expense = new Expense("Food", 10.5, "Lunch");
        expense.setAmount(20.0);
        assertEquals(20.0, expense.getAmount(), 0.01);
    }

    @Test
    public void testSetDescription() {
        Expense expense = new Expense("Food", 10.5, "Lunch");
        expense.setDescription("Dinner");
        assertEquals("Dinner", expense.getDescription());
    }

    @Test
    public void testSetCategoryWithNull() {
        Expense expense = new Expense("Food", 10.5, "Lunch");
        expense.setCategory(null);
        assertEquals(null, expense.getCategory());
    }

    @Test
    public void testSetDescriptionWithNull() {
        Expense expense = new Expense("Food", 10.5, "Lunch");
        expense.setDescription(null);
        assertEquals(null, expense.getDescription());
    }
}
