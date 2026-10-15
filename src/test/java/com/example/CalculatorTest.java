package com.example;

import com.example.model.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Calculator 类的单元测试
 * 测试加法、减法、乘法、除法等基本运算
 */
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(15, calculator.add(10, 5));
        assertEquals(0, calculator.add(-10, 10));
        assertEquals(-15, calculator.add(-10, -5));
    }

    @Test
    void testSubtract() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-15, calculator.subtract(-10, 5));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(50, calculator.multiply(10, 5));
        assertEquals(-50, calculator.multiply(-10, 5));
        assertEquals(0, calculator.multiply(10, 0));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calculator.divide(10, 5));
        assertEquals(-2.0, calculator.divide(-10, 5));
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}
