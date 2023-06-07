package utils;

public class IntegerChecker {
    /***
     * To check whether the integer is in range [min, max]
     * @param value The integer
     * @param min Lower bound
     * @param max Upper bound
     * @return true iff the integer is in range [min, max]
     */
    public static boolean inRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
}
