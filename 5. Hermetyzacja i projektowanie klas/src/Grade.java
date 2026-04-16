import java.util.ArrayList;

// Klasa Grade (niemutowalna)
class Grade {
    private final String subject;
    private final double value;

    public Grade(String subject, double value) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be empty");
        }
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException("Invalid grade value");
        }
        this.subject = subject;
        this.value = value;
    }

    public String getSubject() {
        return subject;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Grade[subject=" + subject + ", value=" + value + "]";
    }
}


// Klasa Student
class Student {
    private String name;
    private ArrayList<Grade> grades;

    public Student(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(Grade grade) {
        if (grade == null) {
            throw new IllegalArgumentException("Grade cannot be null");
        }
        grades.add(grade);
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0.0;

        double sum = 0;
        for (Grade g : grades) {
            sum += g.getValue();
        }
        return sum / grades.size();
    }

    public Grade getHighest() {
        if (grades.isEmpty()) return null;

        Grade best = grades.get(0);
        for (Grade g : grades) {
            if (g.getValue() > best.getValue()) {
                best = g;
            }
        }
        return best;
    }

    public Grade getLowest() {
        if (grades.isEmpty()) return null;

        Grade worst = grades.get(0);
        for (Grade g : grades) {
            if (g.getValue() < worst.getValue()) {
                worst = g;
            }
        }
        return worst;
    }

    public int getGradeCount() {
        return grades.size();
    }

    @Override
    public String toString() {
        return "Student[name=" + name + ", grades=" + getGradeCount() + "]";
    }
}