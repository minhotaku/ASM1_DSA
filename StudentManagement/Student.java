public class Student {
    private int id;
    private String name;
    private double marks;
    private String rank;

    public Student() {
    }

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void calculateRank() {
        if (marks >= 0 && marks < 5.0) {
            rank = "Fail";
        } else if (marks < 6.5) {
            rank = "Medium";
        } else if (marks < 7.5) {
            rank = "Good";
        } else if (marks < 9.0) {
            rank = "Very Good";
        } else if (marks <= 10.0) {
            rank = "Excellent";
        } else {
            rank = "Invalid Marks";
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Student Details:\n" +
                        "----------------\n" +
                        "ID    : %d\n" +
                        "Name  : %s\n" +
                        "Marks : %.2f\n" +
                        "Rank  : %s",
                id, name, marks, rank
        );
    }
}