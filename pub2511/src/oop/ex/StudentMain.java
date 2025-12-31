package oop.ex;

public class StudentMain {
	
	public static void main(String[] args) {
		
		printStudent(makeStudent("홍길동", 100, 90, 80));
		printStudent(makeStudent("강감찬", 90, 80, 70));
		printStudent(makeStudent("이순신", 80, 70, 60));
		
	} // main
	
	private static Student makeStudent(String name, int kor, int eng, int math) {
		Student student = new Student(name);
		student.setScore(student.new Score(kor, eng, math));
		return student;
	}
	
	private static void printStudent(Student student) {
		System.out.println(student);
	}

} // class





















