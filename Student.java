import java.util.Arrays;

class Student {
    private int rollNumber;
    private String studentName;
    private int[] marks = new int[3];

    // Constructor
    public Student(int rollNumber, String studentName, int[] marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
    }

    // Validate Marks
    public void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException(
                    "Invalid marks for subject " + (i + 1) + ": " + marks[i]
                );
            }
        }
    }

    // Calculate Average
    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / 3.0;
    }

    // Display Result
    public void displayResult() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Student Name: " + studentName);
        System.out.println("Marks: " + Arrays.toString(marks));
        double avg = calculateAverage();
        System.out.println("Average: " + avg);

        if (avg >= 40)
            System.out.println("Result: Pass");
        else
            System.out.println("Result: Fail");
    }

    public int getRollNumber() {
        return rollNumber;
    }
}
