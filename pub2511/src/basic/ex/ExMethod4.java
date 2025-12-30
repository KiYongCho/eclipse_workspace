package basic.ex;

import java.util.Scanner;

public class ExMethod4 {
	
	public static void main(String[] args) {
		printStar(getStarCount());
	}
	
	static int getStarCount() {
		Scanner scanner = new Scanner(System.in);
		int inputNum = scanner.nextInt();
		scanner.close();
		return inputNum;
	}
	
	static void printStar(int starCount) {
		for (int i=0; i<starCount; i++) {
			for (int j=0; j<i+1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

}









