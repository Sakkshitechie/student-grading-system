import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private int[] marks;
    Scanner scanner = new Scanner(System.in);
    public void inputDetails() {
        System.out.print("Enter student name: ");
        name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        rollNumber = scanner.nextInt();
    }
    public void inputMarks() {
        marks = new int[5]; // Assuming there are 5 subjects
        
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }
    
    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
    
    public String getGrade() {
        double average = calculateAverage();
        
        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Average Marks: " + calculateAverage());
        System.out.println("Grade: " + getGrade());
    }
}

class GradingSystem {
    private Student[] students;
    Scanner scanner = new Scanner(System.in);
    public void inputStudents() {
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        students = new Student[numStudents];
        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            students[i] = new Student();
            students[i].inputDetails();
            students[i].inputMarks();
        }
    }
    
    public double calculateClassAverage() {
        double sum = 0;
        for (Student student : students) {
            sum += student.calculateAverage();
        }
        return sum / students.length;
    }
    
    public void displayStudentDetails() {
        for (Student student : students) {
            student.displayDetails();
            System.out.println();
        }
    }
    
    public void displayClassAverage() {
        System.out.println("Class Average Marks: " + calculateClassAverage());
    }
}

public class Main {
    public static void main(String[] args) {
        GradingSystem gradingSystem = new GradingSystem();
        gradingSystem.inputStudents();
        System.out.println();
        gradingSystem.displayStudentDetails();
        System.out.println();
        gradingSystem.displayClassAverage();
    }
}
