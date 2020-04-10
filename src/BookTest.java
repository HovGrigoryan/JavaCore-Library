import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        DynamicArrayForBook book = new DynamicArrayForBook();

        Scanner scanner = new Scanner(System.in);
        System.out.println("write how many books dou you want");
        int countAll = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countAll; i++) {
            System.out.println("Which Book do you want");
            String title = scanner.nextLine();
            System.out.println("Who's Book do you want");
            String author = scanner.nextLine();
            System.out.println("How much does it cost");
            String price = scanner.nextLine();
            System.out.println("How many");
            String count = scanner.nextLine();
            Book b = new Book();
            b.setTitle(title);
            b.setAuthorName(author);
            b.setPrice(Double.parseDouble(price));
            b.setCount(Integer.parseInt(count));
            System.out.println(b);
            
            book.add(b);
        }
        System.out.println("Which Book info do you want");
        String title = scanner.nextLine();
        System.out.println(book.getBookBytitle(title));


//        Book book1 = new Book("Մակբեթ", " Ուիլիամ Շեքսպիր", 2000, 5);
//        System.out.println(book1);
//        book1.setTitle(" Անասնաֆերմա");
//        System.out.println(book1.getTitle());
//        book1.setAuthorName("Ջորջ Օրուել");
//        System.out.println(book1.getAuthorName());
//        book1.setPrice(3000);
//        System.out.println(book1.getPrice());
//        book1.setCount(7);
//        System.out.println(book1.getCount());
//        System.out.println(book1);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Hi");
//        System.out.println("I hope, you are fine");
//        System.out.println("pleas ask me which books do you want to read");
//        String title = scanner.nextLine();
//        System.out.println("Who's author");
//        String authorName = scanner.nextLine();
//        System.out.println("how much does it cost");
//        String price = scanner.nextLine();
//        System.out.println("how many");
//        String count = scanner.nextLine();
//        Book book = new Book();
//        book.setTitle(title);
//        book.setAuthorName(authorName);
//        book.setPrice(Integer.parseInt(price));
//        book.setCount(Integer.parseInt(count));
//        System.out.println(book);
    }
}
