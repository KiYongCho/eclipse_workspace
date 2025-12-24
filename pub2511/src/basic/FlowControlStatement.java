package basic;

public class FlowControlStatement {
	
	public static void main(String[] args) {
		
		// if
		int i1 = 5;
		
		if (i1>5) {
			System.out.println("i1은 5보다 큽니다!");
		} else {
			System.out.println("i1은 5보다 크지 않습니다!");
		}
		
		i1 = 35;
		
		if (i1<10) {
			System.out.println("i1은 10보다 작습니다!");
		} else if (i1<20) {
			System.out.println("i1은 20보다 작습니다!");
		} else if (i1<30) {
			System.out.println("i1은 30보다 작습니다!");
		} else {
			System.out.println("i1은 30보다 작지 않습니다!");
		}
		
		// switch
		
		int yoil = 3;
		
		switch (yoil) { // switch 괄호안에는 byte, short, int char, String
			case 0: System.out.println("일"); break;
			case 1: System.out.println("월"); break;
			case 2: System.out.println("화"); break;
			case 3: System.out.println("수"); break;
			case 4: System.out.println("목"); break;
			case 5: System.out.println("금"); break;
			case 6: System.out.println("토");
		}
		
		switch ("남자") {
			case "남자": System.out.println("male"); break;
			case "여자": System.out.println("female");
		}
		
		// for
		
		for (int i=0; i<10; i++) {
			System.out.println(i);
		}
		
		for (int i=1; i<100; i=i+2) {
			System.out.println(i);
		}
		
		// while
		
		int i2 = 1;
		while (i2<10) {
			System.out.println(i2);
			i2++;
		}
		
		// do ~ while
		
		i2 = 0;
		
		do {
			System.out.println(i2);
			i2++;
		} while (i2<5);
		
		// 실습 : while문을 이용해서 1~100 중에서 짝수만 출력
		int i3 = 1;
		while (i3<=100) {
			if (i3%2==0) System.out.println(i3);
			i3++;
		}		
		
		// 실습 : while문을 이용해서 50부터 100까지의 정수 중에서 7의 배수만 출력
		int i4 = 50;
		while (i4<=100) {
			if (i4%7==0) System.out.println(i4);
			i4++;
		}		
		
		
	} // main

} // class



















