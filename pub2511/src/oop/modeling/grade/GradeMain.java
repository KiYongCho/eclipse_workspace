package oop.modeling.grade;

public class GradeMain {

	public static void main(String[] args) {
		
		Student hong = new Student("S001", "홍길동");

		hong.enroll(new Subject("수학", new BasicGradePolicy()), 85);
		hong.enroll(new Subject("윤리", new PFGradePolicy()), 65);

		hong.printInfo();
		
	} // main

} // class



















