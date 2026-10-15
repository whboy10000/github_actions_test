package com.example;

import com.example.model.Calculator;
import com.example.service.GreetingService;

/**
 * 主应用程序入口类
 * 这是一个简单的 GitHub Actions CI 实战示例项目
 */
public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        System.out.println("=== GitHub Actions Maven Demo ===");
        System.out.println("计算器示例:");
        System.out.println("10 + 5 = " + calculator.add(10, 5));
        System.out.println("10 - 5 = " + calculator.subtract(10, 5));
        System.out.println("10 * 5 = " + calculator.multiply(10, 5));
        System.out.println("10 / 5 = " + calculator.divide(10, 5));
        System.out.println("=================================");
        
        // 使用 GreetingService
        GreetingService greetingService = new GreetingService();
        System.out.println("\n" + greetingService.greet("GitHub Actions CI"));
    }
}
