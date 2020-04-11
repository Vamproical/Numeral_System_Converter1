package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int base = Integer.parseInt(scanner.nextLine());
            String number = scanner.nextLine();
            int targetBase = scanner.nextInt();
            if (base < 1 || base > 36 || targetBase < 1 || targetBase > 36) {
                throw new Exception("Error!");
            }
            String[] arrayNumber = number.split("\\.");
            if (arrayNumber.length == 1) {
                System.out.println(Converter.convertInteger(base, arrayNumber[0], targetBase));
            } else {
                System.out.println(Converter.convertInteger(base, arrayNumber[0], targetBase) + Converter.convertDecimal("." + arrayNumber[1], base, targetBase));
            }
        }
        catch (Exception e) {
            System.out.println("Error!");
        }
    }
}
