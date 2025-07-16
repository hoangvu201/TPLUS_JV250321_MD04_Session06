package ra.validator;

import java.util.Scanner;

public class Validation {
    public static boolean isEmpty(String inputData){
        if (inputData != null && !inputData.trim().isEmpty()){
            return false;
        }
        return true;
    }

    public static  int inputChoice(Scanner scanner,String message, int maxValue){
        System.out.println(message);
        do {
            if (scanner.hasNextInt()) {
                int value  = Integer.parseInt(scanner.next());
                if (value>= 1 && value <= maxValue){
                    return value;
                }
                System.err.println("Giá trị nhập không hợp lệ, vui lòng nhập lại");
                return Integer.parseInt(scanner.nextLine());
            }
            System.err.println("Phản là số nguyên, vui lòng nhập lại");
        }while (true);
    }
}

