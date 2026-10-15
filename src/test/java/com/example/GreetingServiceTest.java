package com.example;

import com.example.service.GreetingService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * GreetingService 类的单元测试
 */
class GreetingServiceTest {

    private GreetingService greetingService;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        greetingService = new GreetingService();
    }

    @Test
    void testGreetWithName() {
        assertEquals("Hello, GitHub Actions CI! Welcome to GitHub Actions CI.",
                     greetingService.greet("GitHub Actions CI"));
    }

    @Test
    void testGreetWithEmptyName() {
        assertEquals("Hello, World!", greetingService.greet(""));
    }

    @Test
    void testGreetWithNullName() {
        assertEquals("Hello, World!", greetingService.greet(null));
    }
}
