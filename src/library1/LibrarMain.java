package library1;

import java.util.Scanner;

public class LibrarMain {
    static DataStorage dataStorage = new DataStorage();
    static Scanner scanner = new Scanner(System.in);
    private static final int EXIT = 0;
    private static final int ADD = 1;
    private static final int SEARCH = 2;
    private static final int DELETE = 3;
    private static final int PRINT_ALL = 4;

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            printCommands();
            String commandStr = scanner.nextLine();
            int command = Integer.parseInt(commandStr);
            switch (command) {
                case EXIT:
                    isRun = false;
                    System.out.println(" Հաջողություն");
                    break;
                case ADD:
                    addBook();
                    break;
                case SEARCH:
                     search();
                    break;
                case DELETE:
                    delete();
                    break;
                case PRINT_ALL:
                    dataStorage.print();
                    break;
                default:
                    System.out.println("Սխալ հրաման");
            }
        }

    }

    private static void delete() {
        dataStorage.print();
        System.out.println(" Ներմուծել գրքի իդ-ն  ջնջելու համար");
        String bookId = scanner.nextLine();
        dataStorage.deleteByBookId(bookId);

    }

    private static void search() {
        System.out.println("Ներմուծեք փնտրվող  բառը");
        String keyword = scanner.nextLine();
        dataStorage.search(keyword);

    }

    private static void addBook() {
        System.out.println("Ներմուծեք հեղինակի տվյալները" + "(name, surname,email,gender) ");
        String authorDataStr = scanner.nextLine();
        String[] authorData = authorDataStr.split(",");
        Author author = new Author();
        author.setName(authorData[0]);
        author.setSurname(authorData[1]);
        author.setEmail(authorData[2]);
        author.setGender(authorData[3]);


        System.out.println("Ներմուծեք գրքի  տվյալները " + "(bookId, title, description, price, count)");
        String bookDataStr = scanner.nextLine();
        String[] bookData = bookDataStr.split(",");
        Book book = new Book();
        book.setBookId(bookData[0]);
        book.setTitle(bookData[1]);
        book.setDescription(bookData[2]);
        book.setAuthor(author);
        book.setPrice(Double.parseDouble(bookData[3]));
        book.setCount(Integer.parseInt(bookData[4]));

        dataStorage.add(book);
        System.out.println("Գիրքը ավելացվեց");
    }

         private static void printCommands() {
        System.out.println("Ներմուծել " + EXIT + " դուրս գալու համար");
        System.out.println("Ներմուծել " + ADD + " Գիրք ավելացնելու համար");
        System.out.println("Ներմուծել " + SEARCH + " Գիրք փնտրելու համար");
        System.out.println("Ներմուծել " + DELETE + " Գիրք ջնջելու համար");
        System.out.println("Ներմուծել " + PRINT_ALL + " Գիրք տեսնելու համար");
    }
}
