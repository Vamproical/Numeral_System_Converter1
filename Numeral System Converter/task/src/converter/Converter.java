package converter;

public class Converter {
    public static String convertInteger(int base, String number, int targetBase) {
        long x = (base > 1) ? Long.parseLong(number, base) : number.length();
        if (targetBase == 1) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < x; i++) {
                result.append("1");
            }
            return result.toString();
        }
        return Long.toString(x, targetBase);
    }
    public static String convertDecimal(String baseNumber, int baseRadix, int targetRadix) {
        if (targetRadix == 1) {
            return "";
        }
        if (baseRadix != 10) {
            return convertFromDecimal(convertToDecimalRadix(baseNumber, baseRadix), targetRadix);
        }
        return convertFromDecimal(Double.parseDouble(baseNumber), targetRadix);
    }

    private static double convertToDecimalRadix(String baseNumber, int baseRadix) {
        double sum = 0;
        for (int i = 1; i < baseNumber.length(); i++) {
            sum += (Character.getNumericValue(baseNumber.charAt(i)) / Math.pow(baseRadix, i));
        }
        return sum;
    }
    private static String convertFromDecimal(double baseNumber, int targetRadix) {
        double temp;
        StringBuilder result = new StringBuilder(".");
        for (int i = 0; i < 5; i++) {
            temp = baseNumber * targetRadix;
            result.append(convertInteger(10, Integer.toString((int) temp), targetRadix));
            baseNumber = temp - (int) temp;
        }
        return result.toString().substring(0, 6);
    }
}
