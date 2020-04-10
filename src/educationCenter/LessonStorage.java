package educationCenter;

public class LessonStorage {
    private Lesson lessons[];
    int size;

    LessonStorage(int capacity) {
        lessons = new Lesson[capacity];
    }

    LessonStorage() {
        lessons = new Lesson[15];
    }
    public void add (Lesson lesson){
        if (size == lessons.length){
            extend();
        }
        lessons[size++] =lesson;
    }

    private void extend() {
        Lesson tmp [] = new Lesson[lessons.length + 10];
        System.arraycopy(lessons,0,tmp,0,lessons.length);
        lessons= tmp;
    }

    public void print(){
        if(size == 0){
            System.out.println(" Ոչինչ չկա դատարկ է");
        }
        for (int i = 0; i <size ; i++) {
                System.out.println(lessons[i]);
        }
    }
    public void deleteByIndex(int index){
        for (int i = index + 1; i <size ; i++) {
            lessons[i-1] = lessons[i];
        }
        size--;
    }
    public  Lesson getByName(String name){
        for (int i = 0; i <size ; i++) {
            if (lessons[i].getName().equals(name)){
                    return lessons[i];
            }
        }
        return null;


    }
}
