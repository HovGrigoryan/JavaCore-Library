package library1;

public class DataStorage {
    public static void main(String[] args) {

    }

    private Book[] books;
    private int size;

    public DataStorage(int capacity) {
        books = new Book[capacity];
    }

    public DataStorage() {
        books = new Book[16];
    }

    public void add(Book book) {
        if (size == books.length) {
            extend();
        }
        books[size++] = book;
    }

    private void extend() {
        Book[] tmp = new Book[books.length + 10];
        System.arraycopy(books, 0, tmp, 0, books.length);
        books = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);

        }
    }

    public void search(String keyword) {
        boolean isFound = false;
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(keyword)) {
                System.out.println(books[i]);
                isFound = true;
            }

        }
        if (!isFound){
            System.out.println("Ոչ մի բան չգտնվեց ");
        }
    }

    private void deleteByIndex(int index) {
        for (int i = index + 1; i < size; i++) {
            books[i - 1] = books[i];
        }
        size--;
    }

    public void deleteByBookId(String bookId) {
        for (int i = 0; i < size; i++) {
            if (books[i].getBookId().equals(bookId)) {
                deleteByIndex(i);
            }
        }
    }
}
