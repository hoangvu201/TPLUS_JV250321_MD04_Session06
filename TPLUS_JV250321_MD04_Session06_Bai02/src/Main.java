//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Book myBook = new Book();
        myBook.setTitle("Java Programming");
        myBook.setAuthor("John Doe");

        myBook.setPrice(29.99F);
        System.out.println("Title: " + myBook.getTitle());
        System.out.println("Author: " + myBook.getAuthor());
        System.out.println("Price: " + myBook.getPrice());

        myBook.setPrice(35.50F);
        System.out.println("New Price: " + myBook.getPrice());

        myBook.setPrice(-7F);
    }
}