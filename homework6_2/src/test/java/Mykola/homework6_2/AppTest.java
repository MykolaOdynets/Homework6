package Mykola.homework6_2;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AppTest {
    private Calculator calculator = new Calculator();

    // Start of Assert and SoftAssert Tests
    @Test
    public void TestSumAsserts() throws Exception {
        assertEquals(-1, calculator.add(-4,3));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }

    @Test
    public void TestSubAsserts() throws Exception {
        assertEquals(2, calculator.substract(4,2));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }

    @Test
    public void TestMulAsserts() throws Exception {
        assertEquals(8, calculator.multiply(4,2));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }

    @Test
    public void TestDivAsserts() throws Exception {
        assertEquals(3, calculator.divide(6,2),"Something go wrong");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();

    }
    // start of XML Tests
    
    @Parameters({ "number1", "number2", "sum" })
    @Test
    public void testAdd(@Optional("5") int number1, @Optional("2") int number2, @Optional("7") int sum) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(number1, number2), sum);
    }
    
    @Parameters({ "number1", "number2", "difference" })
    @Test
    public void testSubtract(@Optional("5") int number1, @Optional("2") int number2, @Optional("3") int difference) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.substract(number1, number2), difference);
    }

    @Parameters({ "number1", "number2", "multiplication" })
    @Test
    public void testMultiply(@Optional("5") int number1, @Optional("5") int number2, @Optional("25") int multiplication) {
        Calculator calculator = new Calculator();
            Assert.assertEquals(calculator.multiply(number1, number2), multiplication);
    }

    @Parameters({ "number1", "number2", "division" })
    @Test
    public void testDivide(@Optional("10") int number1, @Optional("5") int number2, @Optional("2") int division) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(number1, number2), division);
    }
    
    // Start of DataProvider Tests

    @DataProvider
    public Object[][] summLocalData() {
        return new Object[][]{
                {5, calculator.add(2, 3)},

        };
    }

    @Test(dataProvider = "summLocalData")
    public void sum(int result, int sumDigit) throws Exception {
        assertEquals(result, sumDigit);
    }

    @DataProvider
    public Object[][] subLocalData() {
        return new Object[][]{
                {2, calculator.substract(7, 5)},

        };
    }

    @Test(dataProvider = "subLocalData")
    public void sub(int result, int sumDigit) throws Exception {
        assertEquals(result, sumDigit);
    }

    @DataProvider
    public Object[][] mulLocalData() {
        return new Object[][]{
                {6, calculator.multiply(2, 3)},

        };
    }

    @Test(dataProvider = "mulLocalData")
    public void mul(int result, int sumDigit) throws Exception {
        assertEquals(result, sumDigit);
    }

    @DataProvider
    public Object[][] divLocalData() {
        return new Object[][]{
                {5, calculator.add(2, 3)},

        };
    }

    @Test(dataProvider = "divLocalData")
    public void div(int result, int sumDigit) throws Exception {
        assertEquals(result, sumDigit);
    }

    
    
    
}



