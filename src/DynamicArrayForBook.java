public class DynamicArrayForBook extends Book {
    private Book array[] = new Book[4];
    //ավելացված էլեմենտների քանակ
    private int size=0;

    public void add (Book value) {
        if (size == array.length) {
            extend();
            array[size++] = value;
        } else {
            array[size++] = value;
        }
    }


    private void extend() {
        Book array1[] = new Book[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            array1[i] = array[i];
        }
        array = array1;
    }

    public Book getBookBytitle(String title) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getTitle().equals(title)) {
                return array[i];
            }
        }
        return null;


    }
}