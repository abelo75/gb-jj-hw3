import java.io.*;

public class Student implements Serializable {
    private final String name;
    private final int age;
    transient double gpa;

    public Student() {
        this.name = "";
        this.age = 0;
        this.gpa = 0.0;
    }

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAge: %d\nGPA: %.2f\n", this.name, this.age, this.gpa);
    }

}
