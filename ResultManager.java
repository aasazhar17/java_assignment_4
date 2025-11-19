import java.util.Scanner;

public class ResultManager {

    Student[] students = new Student[50]; // Store multiple students
    int count = 0;
    Scanner sc = new Scanner(System.in);

    // Add Student
    public void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
            }

            Student s = new Student(roll, name, marks);

            // Validate marks → may throw exception
            s.validateMarks();

            students[count++] = s;
            System.out.println("Student added successfully.\n");

        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Input Error: " + e.getMessage());

        } finally {
            System.out.println("Returning to main menu...\n");
        }
    }

    // Show Student Details
    public void showStudentDetails() {
        try {
            System.out.print("Enter Roll Number to search: ");
            int roll = sc.nextInt();

            boolean found = false;

            for (int i = 0; i < count; i++) {
                if (students[i].getRollNumber() == roll) {
                    students[i].displayResult();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            System.out.println("Search completed.\n");
        }
    }

    // Main Menu
    public void mainMenu() {
        while (true) {
            System.out.println("===== Student Result Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Student Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    showStudentDetails();
                    break;

                case 3:
                    System.out.println("Exiting program. Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }

    public static void main(String[] args) {
        ResultManager rm = new ResultManager();
        rm.mainMenu();
    }
}
