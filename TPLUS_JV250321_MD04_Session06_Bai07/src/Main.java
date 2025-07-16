public class Main {
    public static void main(String[] args) {
        // Tạo hai phân số
        Fraction f1 = new Fraction(2, 4);   // sẽ rút gọn thành 1/2
        Fraction f2 = new Fraction(3, 5);

        // In ra phân số ban đầu
        System.out.println("Phân số 1: " + f1);
        System.out.println("Phân số 2: " + f2);

        // Gọi từng phép toán
        congPhanSo(f1, f2);
        truPhanSo(f1, f2);
        nhanPhanSo(f1, f2);
        chiaPhanSo(f1, f2);
    }

    // Phép cộng
    public static void congPhanSo(Fraction a, Fraction b) {
        Fraction kq = a.add(b);
        System.out.println("Tổng: " + kq);
    }

    // Phép trừ
    public static void truPhanSo(Fraction a, Fraction b) {
        Fraction kq = a.subtract(b);
        System.out.println("Hiệu: " + kq);
    }

    // Phép nhân
    public static void nhanPhanSo(Fraction a, Fraction b) {
        Fraction kq = a.multiply(b);
        System.out.println("Tích: " + kq);
    }

    // Phép chia
    public static void chiaPhanSo(Fraction a, Fraction b) {
        Fraction kq = a.divide(b);
        System.out.println("Thương: " + kq);
    }
}
