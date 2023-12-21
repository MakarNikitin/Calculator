public class ExceptionChecker {
    public void checkInput(String[] sortedArray) {
        if (sortedArray.length != 3) {
            throw new IllegalArgumentException("Нужно ввести выражение типа: a + a");
        }
    }
}