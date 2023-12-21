class NumberSystemChecker {
    public boolean rimOrArabianChecking(String[] sortedArray) {
        try {
            Integer.parseInt(sortedArray[0]);
            Integer.parseInt(sortedArray[2]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}