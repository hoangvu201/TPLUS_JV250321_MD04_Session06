public class Student {
    private String name;
    private int age;
    private String classroom;
    private double avgScore;

    public Student(){

    }

    public Student(String name, int age, String classroom, double avgScore) {
        this.name = name;
        this.age = age;
        this.classroom = classroom;
        this.avgScore = avgScore;
    }

    public String getName() {
        return name;
    }

    public String getClassroom() {
        return classroom;
    }

    public double getAvgScore() {
        return avgScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Tên: " + name + '\'' +
                ", Tuổi: " + age +
                ", Lớp: " + classroom + '\'' +
                ", Điểm trung bình: " + avgScore +
                '}';
    }
}
