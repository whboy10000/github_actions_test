package main

import "testing"

func TestIsEven(t *testing.T) {
	// 定义测试用例表
	tests := []struct {
		input    int
		expected bool
	}{
		{2, true},
		{3, false},
		{0, true},
		{-4, true},
		{-7, false},
	}

	// 遍历并执行测试
	for _, test := range tests {
		result := IsEven(test.input)
		if result != test.expected {
			t.Errorf("IsEven(%d) 返回了 %v; 期望是 %v", test.input, result, test.expected)
		}
	}
}