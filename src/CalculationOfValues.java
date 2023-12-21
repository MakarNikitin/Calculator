class CalculationOfValues {
    public String calculatingOfValues(String[] sortedArray, boolean rimCheckerIndex) {
        NumbersConversion numbersConversion = new NumbersConversion();
        int[] rimArrayConvertedToArabian = numbersConversion.romanToArabic(sortedArray);
        int result;
        int firstValue = rimArrayConvertedToArabian[0];
        int secondValue = rimArrayConvertedToArabian[1];
        result = switch (sortedArray[1]) {
            case ("-") -> firstValue - secondValue;
            case ("+") -> firstValue + secondValue;
            case ("*") -> firstValue * secondValue;
            case ("/") -> firstValue / secondValue;
            default -> throw new IllegalArgumentException("Указан неверный операнд");
        };
        if (rimCheckerIndex) {
            return String.valueOf(result);
        } else {
            if (result <= 0) {
                throw new IllegalArgumentException("В римской системе счисления нет отрицательных чисел");
            }
            return numbersConversion.arabicToRoman(result);
        }
    }
}