package com.example.model;

/**
 * 计算器模型类
 * 提供基本的四则运算功能
 */
public class Calculator {

    /**
     * 加法运算
     * @param a 第一个数
     * @param b 第二个数
     * @return 两数之和
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * 减法运算
     * @param a 被减数
     * @param b 减数
     * @return 差
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * 乘法运算
     * @param a 第一个数
     * @param b 第二个数
     * @return 积
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * 除法运算
     * @param a 被除数
     * @param b 除数
     * @return 商
     * @throws ArithmeticException 当除数为零时抛出
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return (double) a / b;
    }
}
