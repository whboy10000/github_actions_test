package main

import "fmt"

// IsEven 判断一个整数是否为偶数
func IsEven(n int) bool {
	return n%2 == 0
}

func main() {
	fmt.Println("4 是偶数吗?", IsEven(4))
	fmt.Println("7 是偶数吗?", IsEven(7))
}