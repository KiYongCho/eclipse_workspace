package api;

import java.math.BigInteger;

public class BigIntegerTest {
	
	public static void main(String[] args) {
		
		// long의 범위(약 9경, 19자리)를 넘는 정수는 BigInteger
		BigInteger bi1 = new BigInteger("438957894327589474893579547389574975349857");
		BigInteger bi2 = new BigInteger("3298478329479234794873894783924983289384");
		
		System.out.println(bi1.add(bi2)); // 덧셈
		System.out.println(bi1.subtract(bi2)); // 뺄셈
		System.out.println(bi1.multiply(bi2)); // 곱셈
		System.out.println(bi1.divide(bi2)); // 나눗셈
		System.out.println(bi1.remainder(bi2)); // 나머지
		
		// double의 범위를 넘는 실수는 BigDecimal
		
	}

}







































