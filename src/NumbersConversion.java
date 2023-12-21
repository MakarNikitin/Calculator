import java.util.List;

class NumbersConversion {
    public int[] romanToArabic(String[] sortedArray) {
        NumberSystemChecker numberSystemChecker = new NumberSystemChecker();
        int firstValue = 0;
        int secondValue = 0;
        int i = 0;
        int j = 0;
        if (numberSystemChecker.rimOrArabianChecking(sortedArray)) {
            firstValue = Integer.parseInt(sortedArray[0]);
            secondValue = Integer.parseInt(sortedArray[2]);
        }
        List<RimNumberIdentification> rimNumberIdentification = RimNumberIdentification.getReverseSortedValues();
        while ((sortedArray[0].length() > 0) && (i < RimNumberIdentification.getReverseSortedValues().size())) {
            RimNumberIdentification symbol = rimNumberIdentification.get(i);
            if (sortedArray[0].startsWith(symbol.name())) {
                firstValue += symbol.getValue();
                sortedArray[0] = sortedArray[0].substring(symbol.name().length());
            } else {
                i++;
            }
        }
        while ((sortedArray[2].length() > 0) && (j < RimNumberIdentification.getReverseSortedValues().size())) {
            RimNumberIdentification symbol = rimNumberIdentification.get(j);
            if (sortedArray[2].startsWith(symbol.name())) {
                secondValue += symbol.getValue();
                sortedArray[2] = sortedArray[2].substring(symbol.name().length());
            } else {
                j++;
            }
        }
        if (firstValue > 10 | secondValue > 10) {
            throw new IllegalArgumentException("Необходимо ввести числа от 1 до 10");
        } else if (firstValue == 0 | secondValue == 0) {
            throw new IllegalArgumentException("Введите числа одной системы счисления");
        }
        int[] rimArrayConvertedToArabian = new int[2];
        rimArrayConvertedToArabian[0] = firstValue;
        rimArrayConvertedToArabian[1] = secondValue;
        return rimArrayConvertedToArabian;
    }

    public String arabicToRoman(int result) {
        List<RimNumberIdentification> rimNumberIdentification = RimNumberIdentification.getReverseSortedValues();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        RimNumberIdentification currentSymbol;
        while ((result > 0) && (i < rimNumberIdentification.size())) {
            currentSymbol = rimNumberIdentification.get(i);
            if (currentSymbol.getValue() <= result) {
                sb.append(currentSymbol.name());
                result -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}