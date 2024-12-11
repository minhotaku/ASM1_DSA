import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class StudentStack {
    private Node top;

    public StudentStack() {
        top = null;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    public Student pop() {
        if (isEmpty()) {
            return null;
        }
        Student poppedStudent = top.student;
        top = top.next;
        return poppedStudent;
    }

    public Student peek() {
        if (isEmpty()) {
            return null;
        }
        return top.student;
    }


    public boolean isEmpty() {
        return top == null;
    }
    public static StudentStack copyStack(StudentStack originalStack) {
        StudentStack tempStack = new StudentStack();
        StudentStack copyStack = new StudentStack();

        // Pop all students from original to tempStack, effectively reversing the order
        while (!originalStack.isEmpty()) {
            tempStack.push(originalStack.pop());
        }

        // Pop all students from tempStack to copyStack, restoring the original order
        while (!tempStack.isEmpty()) {
            Student student = tempStack.pop();
            copyStack.push(student);
            originalStack.push(student); // Push back to the original stack
        }

        return copyStack;
    }

    public static StudentStack generateRandomStudents(int numStudents) {
        StudentStack studentStack = new StudentStack();
        Random random = new Random();

        for (int i = 1; i <= numStudents; i++) {
            // Generate random ID
            int id = i;

            String name = "Student " + i;

            // Generate random marks between 0 and 10
            double marks = random.nextDouble() * 10;

            Student student = new Student(id, name, marks);
            student.calculateRank();
            studentStack.push(student);
        }

        return studentStack;
    }

    public static void addStudent(Scanner scanner, StudentStack studentStack) {
        try {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Validate ID
            if (id <= 0) {
                throw new IllegalArgumentException("Invalid ID. ID must be a positive integer.");
            }

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            // Validate name
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid name. Name cannot be empty.");
            }

            System.out.print("Enter student marks: ");
            double marks = scanner.nextDouble();

            // Validate marks
            if (marks < 0 || marks > 10) {
                throw new IllegalArgumentException("Invalid marks. Marks must be between 0 and 10.");
            }

            Student newStudent = new Student(id, name, marks);
            newStudent.calculateRank();
            studentStack.push(newStudent);
            System.out.println("Student added successfully.");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input format. Please enter the correct data type.");
            scanner.nextLine(); // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editStudent(Scanner scanner, StudentStack studentStack) {
        try {
            System.out.print("Enter the ID of the student to edit: ");
            int targetId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            StudentStack tempStack = new StudentStack();
            boolean found = false;

            while (!studentStack.isEmpty()) {
                Student student = studentStack.pop();
                if (student.getId() == targetId) {
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    // Validate new name
                    if (newName.trim().isEmpty()) {
                        throw new IllegalArgumentException("Invalid name. Name cannot be empty.");
                    }

                    System.out.print("Enter new marks: ");
                    double newMarks = scanner.nextDouble();

                    // Validate new marks
                    if (newMarks < 0 || newMarks > 10) {
                        throw new IllegalArgumentException("Invalid marks. Marks must be between 0 and 10.");
                    }

                    student.setName(newName);
                    student.setMarks(newMarks);
                    student.calculateRank();
                    found = true;
                }
                tempStack.push(student);
            }

            while (!tempStack.isEmpty()) {
                studentStack.push(tempStack.pop());
            }

            if (found) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input format. Please enter the correct data type.");
            scanner.nextLine(); // Clear invalid input
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void deleteStudent(Scanner scanner, StudentStack studentStack) {
        try {
            System.out.print("Enter the ID of the student to delete: ");
            int targetId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            StudentStack tempStack = new StudentStack();
            boolean found = false;

            while (!studentStack.isEmpty()) {
                Student student = studentStack.pop();
                if (student.getId() == targetId) {
                    found = true;
                } else {
                    tempStack.push(student);
                }
            }

            while (!tempStack.isEmpty()) {
                studentStack.push(tempStack.pop());
            }

            if (found) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input format. Please enter the correct data type.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public static void sortStudents(StudentStack studentStack) {
        if (studentStack.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }

        // Pop all students into an array
        Student[] students = new Student[getSize(studentStack)];
        int i = 0;
        while (!studentStack.isEmpty()) {
            students[i++] = studentStack.pop();
        }

        mergeSort(students, 0, students.length - 1);

        // Push the sorted students back onto the stack
        for (Student student : students) {
            studentStack.push(student);
        }
    }

    // Merge Sort implementation
    public static void mergeSort(Student[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void merge(Student[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getMarks() <= R[j].getMarks()) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sortStudentsBubbleSort(StudentStack studentStack) {
        if (studentStack.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }

        // Pop all students into an array
        Student[] students = new Student[getSize(studentStack)];
        int i = 0;
        while (!studentStack.isEmpty()) {
            students[i++] = studentStack.pop();
        }

        // Bubble Sort implementation
        int n = students.length;
        for (i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getMarks() > students[j + 1].getMarks()) {
                    // Swap students[j] and students[j+1]
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        // Push the sorted students back onto the stack
        for (Student student : students) {
            studentStack.push(student);
        }

    }

    public static void searchStudent(Scanner scanner, StudentStack studentStack) {
        System.out.print("Enter the ID of the student to search: ");
        int targetId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == targetId) {
                System.out.println("Student found:");
                System.out.println(student);
                found = true;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void displayStudents(StudentStack studentStack) {
        if (studentStack.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        StudentStack tempStack = new StudentStack();

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            System.out.println(student);
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }
    }

    // Helper function to get the size of the stack
    public static int getSize(StudentStack studentStack) {
        int size = 0;
        StudentStack tempStack = new StudentStack();
        while (!studentStack.isEmpty()) {
            tempStack.push(studentStack.pop());
            size++;
        }
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }
        return size;
    }



}