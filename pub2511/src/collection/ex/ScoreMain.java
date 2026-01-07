package collection.ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScoreMain {
	
	public static void main(String[] args) {
		
		System.out.println("3명의 이름과 국어,영어,수학 점수를 입력해 주세요!");
		System.out.println("입력 형식 : 이름,국어점수,영어점수,수학점수");
		
		Scanner scanner = new Scanner(System.in);
		
		List<Student> studentList = new ArrayList<Student>();
		
		StringTokenizer st = null;
		
		for (int i=0; i<3; i++) {
			st = new StringTokenizer(scanner.next());
			studentList.add(new Student(
				st.nextToken(","), // 이름
				new Score(
					Integer.parseInt(st.nextToken(",")), // 국어점수
					Integer.parseInt(st.nextToken(",")), // 영어점수
					Integer.parseInt(st.nextToken(",")) // 수학점수
				)
			));
		}
		
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		scanner.close();
		
	}

}


























