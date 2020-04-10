package educationCenter;

import java.util.Scanner;

public class EducationCenter {
    static StudentStorage studentStorage = new StudentStorage();
    static LessonStorage lessonStorage = new LessonStorage();
    static Scanner scanner = new Scanner(System.in);

    private static final int EXIT = 0;
    private static final int ADD_STUDENT = 1;
    private static final int ADD_LESSON = 2;
    private static final int PRINT_STUDENTS = 3;
    private static final int PRINT_LESSON = 4;
    private static final int CHANGE_STUDENT_LESSON = 5;
    private static final int PRINT_STUDENTS_BY_LESSON_NAME = 6;

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            printCommands();
            String commandStr = scanner.nextLine();
            int command = Integer.parseInt(commandStr);
            switch (command) {
                case EXIT:
                    isRun = false;
                    System.out.println(" Հաջողություն ");
                    break;
                case ADD_STUDENT:
                    addStudent();
                    //todo
                    break;
                case ADD_LESSON:
                    addlesson();
                    //todo
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_LESSON:
                    lessonStorage.print();
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentLesson();
                    break;
                case PRINT_STUDENTS_BY_LESSON_NAME:
                    studentBylessonName();
                    break;
                default:
                    System.out.println("սխալ հրաման");
                    break;
            }
        }
    }

    private static void studentBylessonName() {
        studentStorage.print();
        System.out.println("Գրեք առարկայի անունը");
        String std = scanner.nextLine();
        Lesson st1 = lessonStorage.getByName(std);
        studentStorage.getBylesson(st1);
    }

    private static void changeStudentLesson() {
        studentStorage.print();
        System.out.println("գրեք այն ուսանողի անունը ում առարկան  ցանկանում եք փոխել");
        String studentchange = scanner.nextLine();
        System.out.println(studentStorage.getByName(studentchange));
        lessonStorage.print();
        System.out.println("գրեք այն առարկաները որոնք ցանկանում եք փոխել");
        String studentless = scanner.nextLine();
        String[] studentlessns = studentless.split(",");
        Lesson[] studentlessnss = new Lesson[studentlessns.length];
        for (int i = 0; i < studentlessns.length; i++) {
            Lesson tmp = lessonStorage.getByName(studentlessns[i]);
            studentlessnss[i] = tmp;
        }
        studentStorage.getByName(studentchange).setLessons(studentlessnss);
    }


    private static void printCommands() {
        System.out.println("Դուրս գալու համար սեղմեք 0");
        System.out.println("Ուսանողների անունները ավելացնելու համար սեղմեք 1");
        System.out.println("Ուսանողի առարկաները ավելացնելու համար սեղմեք 2");
        System.out.println("Ուսանողի անունները տպելու համար սեղմեք 3");
        System.out.println("Առարկաների անունները տպելու համար սեղմեք 4");
        System.out.println("Ուսանողի առարկաները փոխելու համար սեղմեք 5");
        System.out.println("Ուսանողի անունը առարկայով տպելու համար սեղմեք 6");
    }

    private static void addlesson() {
        System.out.println("Գրեք առարկայի տվյալները");
        String lessonss = scanner.nextLine();
        String[] lessonses = lessonss.split(",");
        Lesson lesson = new Lesson();
        lesson.setName(lessonses[0]);
        lesson.setDuration(Integer.parseInt(lessonses[1]));
        lesson.setPrice(Double.parseDouble(lessonses[2]));
        lesson.setLecturerName(lessonses[3]);
        lessonStorage.add(lesson);
        System.out.println("կրկին առարկաներ ավելացնելու համար սեղմեք 2");
    }

    private static void addStudent() {
        System.out.println("գրեք առարկայի անունները");
        String lessonstr = scanner.nextLine();
        String[] lessonsInfo = lessonstr.split(",");
        Lesson[] lessonsInfos = new Lesson[lessonsInfo.length];
        for (int i = 0; i < lessonsInfo.length; i++) {
            Lesson tmp = lessonStorage.getByName(lessonsInfo[i]);
            if (tmp != null) {
                lessonsInfos[i] = tmp;
            } else {
                System.out.println(lessonsInfo[i] + " առարկա չկա,ավելացնելու համար սեղմիր 2");

            }
        }

        System.out.println("Գրեք ուսանողի տվյալները(name, surname,phone,email)");
        String studendInfo = scanner.nextLine();
        String[] studentInfos = studendInfo.split(",");
        Student student = new Student();
        student.setName(studentInfos[0]);
        student.setSurname(studentInfos[1]);
        student.setPhone(studentInfos[2]);
        student.setEmail(studentInfos[3]);
        student.setLessons(lessonsInfos);
        studentStorage.add(student);
    }


}

