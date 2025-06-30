public class Book {
    private String title;
    private String author;
    private Float price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        if (price > 0) {
        this.price = price;
        } else {
            System.out.println("Price cannot be negative");
        }
    }
}
