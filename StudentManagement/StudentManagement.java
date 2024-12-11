import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {

        long startTime, endTime;
        StudentStack tempStack; // To store a copy of the stack

        // Test with 1000 students
        StudentStack stack1000 = StudentStack.generateRandomStudents(1000);

        // Make a copy of the stack for Bubble Sort
        tempStack = StudentStack.copyStack(stack1000);

        startTime = System.nanoTime();
        StudentStack.sortStudents(stack1000); // Merge Sort
        endTime = System.nanoTime();
        System.out.println("Merge Sort time for 1000 students: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        StudentStack.sortStudentsBubbleSort(tempStack); // Bubble Sort on the copy
        endTime = System.nanoTime();
        System.out.println("Bubble Sort time for 1000 students: " + (endTime - startTime) + " nanoseconds");

        // Test with 5000 students
        StudentStack stack5000 = StudentStack.generateRandomStudents(5000);

        // Make a copy of the stack for Bubble Sort
        tempStack = StudentStack.copyStack(stack5000);

        startTime = System.nanoTime();
        StudentStack.sortStudents(stack5000); // Merge Sort
        endTime = System.nanoTime();
        System.out.println("Merge Sort time for 5000 students: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        StudentStack.sortStudentsBubbleSort(tempStack); // Bubble Sort on the copy
        endTime = System.nanoTime();
        System.out.println("Bubble Sort time for 5000 students: " + (endTime - startTime) + " nanoseconds");

        // Test with 10000 students
        StudentStack stack10000 = StudentStack.generateRandomStudents(10000);

        // Make a copy of the stack for Bubble Sort
        tempStack = StudentStack.copyStack(stack10000);

        startTime = System.nanoTime();
        StudentStack.sortStudents(stack10000); // Merge Sort
        endTime = System.nanoTime();
        System.out.println("Merge Sort time for 10000 students: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        StudentStack.sortStudentsBubbleSort(tempStack); // Bubble Sort on the copy
        endTime = System.nanoTime();
        System.out.println("Bubble Sort time for 10000 students: " + (endTime - startTime) + " nanoseconds");


        Scanner scanner = new Scanner(System.in);
        StudentStack students = new StudentStack();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add student");
            System.out.println("2. Edit student");
            System.out.println("3. Delete student");
            System.out.println("4. Sort students by marks");
            System.out.println("5. Search student by ID");
            System.out.println("6. Display all students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    StudentStack.addStudent(scanner, students);
                    break;
                case 2:
                    StudentStack.editStudent(scanner, students);
                    break;
                case 3:
                    StudentStack.deleteStudent(scanner, students);
                    break;
                case 4:
                    StudentStack.sortStudents(students);
                    break;
                case 5:
                    StudentStack.searchStudent(scanner, students);
                    break;
                case 6:
                    StudentStack.displayStudents(students);
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}