
package com.softest;

import org.junit.Before;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
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
        List<Object[]> testData = new ArrayList<>();
        try (Reader in = new FileReader("src/test/resources/expenses.csv")) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(in);
            for (CSVRecord record : records) {
                String category = record.get("category");
                double amount = Double.parseDouble(record.get("amount"));
                String description = record.get("description");
                testData.add(new Object[]{category, amount, description});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testData;
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
        budgetTracker.addExpense(category, amount, description);
        List<Expense> expenses = budgetTracker.getExpenses();
        assertEquals(1, expenses.size());
    }

    @Test
    public void testGetTotalExpenses() {
        budgetTracker.addExpense(category, amount, description);
        double total = budgetTracker.getTotalExpenses();
        assertEquals(amount, total, 0.01);
    }

    @Test
    public void testEmptyExpenses() {
        List<Expense> expenses = budgetTracker.getExpenses();
        assertTrue(expenses.isEmpty());

        double total = budgetTracker.getTotalExpenses();
        assertEquals(0.0, total, 0.01);
    }
}
