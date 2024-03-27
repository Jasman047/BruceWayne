public class Student extends Person {
    private int studentId;

    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I am a student with ID: " + studentId);
    }

    public void study() {
        System.out.println("Studying hard!");
    }
}
