import java.util.Scanner;

public class Rectangle {
    private double width;
    private double height ;

    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return width*height;
    }
    public double getPerimeter() {
        return 2*(width+height);
    }
    public void display() {
        System.out.println("Chiều dài: "+height);
        System.out.println("Chiều rộng: " + width);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi:  " + getPerimeter());
        System.out.println();
    }
}
