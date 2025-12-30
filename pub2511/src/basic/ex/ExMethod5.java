package basic.ex;

public class ExMethod5 {
	
	public static void main(String[] args) {
		
		String[][] studentArr = {
			{"홍길동", "90", "65", "85", "0", "0"},
			{"강감찬", "70", "85", "75", "0", "0"},
			{"이순신", "40", "55", "65", "0", "0"}
		};
		
		for (String[] student : studentArr) {
			print(calc(student));
		}	
		
	} // main

	static String[] calc(String[] student) {
		int sum = 0;
		for (int i=1; i<4; i++) sum += Integer.parseInt(student[i]);
		student[4] = String.valueOf(sum);
		student[5] = String.format("%.2f", (double)sum/3);
		return student;
	}
	
	static void print(String[] student) {
		for (String str : student) System.out.print(str + " ");
		System.out.println();
	}
	
} // class
