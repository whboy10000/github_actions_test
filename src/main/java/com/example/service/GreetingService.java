package com.example.service;

/**
 * 问候服务类
 * 提供个性化的问候功能
 */
public class GreetingService {

    /**
     * 生成问候语
     * @param name 用户名
     * @return 问候语字符串
     */
    public String greet(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello, World!";
        }
        return "Hello, " + name + "! Welcome to GitHub Actions CI.";
    }
}
