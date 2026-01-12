package oop.modeling.grade;

public class Enrollment {
    private Subject subject;
    private int score;

    public Enrollment(Subject subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }
}