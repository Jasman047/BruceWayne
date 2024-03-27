public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", 25);
        Student student = new Student("Alice", 20, 12345);

        person.introduce();
        student.introduce();
        student.study();
    }
}
