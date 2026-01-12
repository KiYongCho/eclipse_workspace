package oop.modeling.grade;

public class Subject {
	
    private String name;
    private GradePolicy gradePolicy;
    
    public Subject() {
	}

    public Subject(String name, GradePolicy gradePolicy) {
        this.name = name;
        this.gradePolicy = gradePolicy;
    }

    public String getName() {
        return name;
    }

    public GradePolicy getGradePolicy() {
        return gradePolicy;
    }
    
}