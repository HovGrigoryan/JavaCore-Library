package educationCenter;

public class StudentStorage {
    private Student students[];
    int size;

    public StudentStorage(int capacity) {
        students = new Student[capacity];
    }

    public StudentStorage() {
        students = new Student[12];
    }

    public void add(Student student) {
        if (size == students.length) {
            extend();
        }
        students[size++] = student;
    }

    private void extend() {
        Student[] tmp = new Student[students.length + 10];
        System.arraycopy(students, 0, tmp, 0, students.length);
        students = tmp;
    }

    public void print() {
        if (size == 0) {
            System.out.println(" Ոչինչ չկա դատարկ է");
        }
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }

    public void deleteByIndex(int index) {
        for (int i = index + 1; i < size; i++) {
            students[i - 1] = students[i];

        }
        size--;
    }

    public Student getByName(String name) {
        for (int i = 0; i < size; i++) {
            if (students[i].getName().equals(name)) {
                return students[i];
            }
        }
        return null;


    }

    public void getBylesson(Lesson lesson) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <students[i].getLessons().length ; j++) {
                if (students[i].getLessons()[j].equals(lesson)){
                    System.out.println(students[i]);

                }

            }



    }

}
}
