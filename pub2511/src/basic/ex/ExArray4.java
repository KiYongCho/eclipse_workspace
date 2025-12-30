package basic.ex;

import java.util.Scanner;

public class ExArray4 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("학생 3명의 이름, 국어점수, 영어점수, 수학점수를 입력해 주세요!");
		System.out.println("(입력형식 : 이름 국어점수 영어점수 수학점수)");

		String[][] inputArr = new String[3][4];
		int inputArrLength = inputArr.length;
		int inputArr0Length = inputArr[0].length;
		
		float[] totalArr = new float[inputArrLength];
		float[] averageArr = new float[inputArrLength];
		
		for (int i=0; i<inputArrLength; i++) {
			for (int j=0; j<inputArr0Length; j++) {
				inputArr[i][j] = scanner.next();
				if (j>0) {
					totalArr[i] += Float.parseFloat(inputArr[i][j]);
				}
			}
			averageArr[i] = totalArr[i] / inputArrLength;			
		}
		
		for (int i=0; i<inputArrLength; i++) {
			for (int j=0; j<inputArr0Length; j++) {
				System.out.print(inputArr[i][j] + " ");
			}
			System.out.printf("총점 %.0f, 평균 %.2f\n", totalArr[i], averageArr[i]);
		}		
		
		scanner.close();
		
	} // main

}
