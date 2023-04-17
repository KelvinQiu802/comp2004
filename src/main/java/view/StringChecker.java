package view;

public class StringChecker {
    /***
     * Check if a string represents an integer.
     * @param str the string need to be checked.
     * @return true if the string represents an integer.
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
