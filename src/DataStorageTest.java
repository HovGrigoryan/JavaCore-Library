import java.util.Scanner;

public class DataStorageTest implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static DataStorage dataStorage = new DataStorage();

    public static void main(String[] args) {


        boolean isRun = true;
        while (isRun) {
            showCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case SEARCH_BY_TITLE:
                    searchBookByTytle();
                    break;
                default:
                    System.out.println("Weong command!");
            }

        }
    }

    private static void showCommands() {
        System.out.println("Please Input" + EXIT + "for Exit");
        System.out.println("Please Input" + ADD_BOOK + "for ADD BOOK");
        System.out.println("Please Input" +SEARCH_BY_TITLE+ "for SEARCH BOOK BY TITLE");
    }

    private static void addBook() {
        System.out.println("Please input Book data ");
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("authorName");
        String authorName = scanner.nextLine();
        System.out.println("Price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("count");
        int count = Integer.parseInt(scanner.nextLine());
        Book book = new Book(title, authorName, price, count);
        dataStorage.add(book);
        System.out.println("Book was added");
        System.out.println("Շնորհակալություն Ձեր գիրքը ավելացավ");
        System.out.println();

    }

    private static void searchBookByTytle() {
        System.out.println("Please input  title for search");
        String searchtitle = scanner.nextLine();
        Book searchedBook = dataStorage.getBookbytitle(searchtitle);
        if (searchedBook == null) {
            System.out.println("Book with" + searchtitle + "title does not exists");

        } else {
            System.out.println(searchedBook);
        }

    }


}
