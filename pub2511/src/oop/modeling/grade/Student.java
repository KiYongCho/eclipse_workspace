package oop.modeling.grade;

public class Student extends User {
	
    private Enrollment[] enrollments = new Enrollment[10];
    private int enrollmentCount = 0;
    
    public Student() {
	}

    public Student(String id, String name) {
        super(id, name);
    }

    public void enroll(Subject subject, int score) {
        if (enrollmentCount < enrollments.length) {
            enrollments[enrollmentCount++] = new Enrollment(subject, score);
        }
    }

    @Override
    public void printInfo() {
        System.out.println(getName() + "님의 성적:");
        for (int i=0; i<enrollmentCount; i++) {
        	Enrollment e = enrollments[i];
            System.out.println("과목: " + e.getSubject().getName() +
                               " / 점수: " + e.getScore() +
                               " / 학점: " + e.getSubject().getGradePolicy().getGrade(e.getScore()));
        }
    }
}