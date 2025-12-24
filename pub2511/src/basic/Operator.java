package basic;

public class Operator {
	
	public static void main(String[] args) {
		
		// 단항 연산자
		int i1 = +5; // 양수, + 생략 가능
		int j1 = -i1; // 음수, - 생략 불가
		
		// 전치/후치 증감 단항 연산자
		int i2 = ++i1; // 전치 증가, i1이 1 증가한 후에 i2에 할당
		int i3 = i1++; // 후치 증가, i1이 i3에 할당된 후 1 증가
		
		// 삼항 연산자
		int i4 = 5;
		int j2 = i4>5 ? 1 : 2;
		
		// 비트 연산자
		byte b1 = 3; // 00000011
		byte b2 = ~3; // 비트반전, 11111100
		byte b3 = 5; // 00000101
		byte b4 = 3 | 5; // 비트OR, 00000011 | 00000101 => 00000111 (둘 중 하나라도 1이면 1)
		byte b5 = 3 & 5; // 비트AND, 00000011 & 00000101 => 00000001 (둘 다 1이면 1)
		byte b6 = 3 ^ 5; // 비트XOR, 00000011 & 00000101 => 00000110 (같으면 0, 다르면 1)
		
		// 시프트 연산자
		// 좌시프트 : 곱하기 2, 우시프트 : 나누기 2
		// 4는 000000100
		// 4 << 2 : 00010000 (16= 4*2^2)
		// 4 >> 2 : 00000001 (1= 4/2^2)
		byte b7 = 5; // 00000101
		byte b8 = 5 >> 3; // 00000000, 비트를 오른쪽으로 수만큼 이동시킨 후 비어있는 비트를 0으로 채움
		byte b9 = (byte)(-5 >>> 3); // 11111111, 비트를 오른쪽으로 수만큼 이동시킨 후 비어있는 비트를 부호비트로 채움
		byte b10 = 3 << 2; // 00001100, 비트를 왼쪽으로 수만큼 이동시킨 후 비어있는 비트를 0으로 채움
		
		// 나머지 연산자
		int i5 = 7;
		int j5 = 3;
		int ri = i5 % j5; // 1
		
		// 관계 연산자
		int i6 = 10;
		int j6 = 5;
		boolean bool1 = i6==j6; // false 
		boolean bool2 = i6!=j6; // true
		boolean bool3 = i6>j6; // true
		boolean bool4 = i6>=j6; // true 
		boolean bool5 = i6<j6; // false
		boolean bool6 = i6<=j6; // false
		
		// 논리 연산자
		boolean bool7 = true;
		boolean bool8 = false;
		boolean bool9 = !bool7; // false, 논리 부정
		boolean bool10 = bool7 | bool8; // true, 논리 OR
		boolean bool11 = bool7 & bool8; // false, 논리 AND
		boolean bool12 = bool7 || bool8; // true, 논리 OR, 좌항이 true면 우항 연산 안함
		boolean bool13 = bool7 && bool8; // false, 논리 AND, 좌항히 false면 우항 연산 안함
		
		// 대입 연산자
		int i8 = 5;
		int i9 = 3;
		i9 += i8; // i9 = i9 + i8;
		i9 -= i8; // i9 = i9 - i8;
		i9 *= i8; // i9 = i9 * i8;
		i9 /= i8; // i9 = i9 / i8;
		i9 %= i8; // i9 = i9 % i8;
		
		// 연산자 우선순위
		// ()가 연산자 우선순위가 가장 높음
		// 대입 연산자는 우선순위가 가장 낮음
		// 단항, 이항, 삼항 순으로 항이 적을 수록 우선순위가 높음
		
		// 양수를 음수 변환 방법 : 양수의 모든 비트를 반전시킨 후 1을 더해 줌
		// 00000101 (십진수 5)
		// 반전 => 11111010
		// +1  => 11111011 (십진수 -5)
		
	}

}
































