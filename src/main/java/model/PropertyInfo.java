package model;

import java.util.HashMap;
import java.util.Map;

public class
PropertyInfo {
    private static Map<Integer, Integer> green = genGreenInfo();
    private static Map<Integer, Integer> darkBlue = genDarkBlueInfo();
    private static Map<Integer, Integer> lightBlue = genLightBlueInfo();
    private static Map<Integer, Integer> red = genRedInfo();
    private static Map<Integer, Integer> utility = genUtilityInfo();
    private static Map<Integer, Integer> yellow = genYellowInfo();
    private static Map<Integer, Integer> orange = genOrangeInfo();
    private static Map<Integer, Integer> brown = genBrownInfo();
    private static Map<Integer, Integer> purple = genPurpleInfo();
    private static Map<Integer, Integer> railroad = genRailroadInfo();

    public static Map<Integer, Integer> getByColor(Colors color) {
        switch (color) {
            case GREEN:
                return new HashMap<>(green);
            case DARK_BLUE:
                return new HashMap<>(darkBlue);
            case LIGHT_BLUE:
                return new HashMap<>(lightBlue);
            case RED:
                return new HashMap<>(red);
            case UTILITY:
                return new HashMap<>(utility);
            case YELLOW:
                return new HashMap<>(yellow);
            case ORANGE:
                return new HashMap<>(orange);
            case BROWN:
                return new HashMap<>(brown);
            case PURPLE:
                return new HashMap<>(purple);
            case RAILROAD:
                return new HashMap<>(railroad);
            default:
                return null;
        }
    }

    private static Map<Integer, Integer> genGreenInfo() {
        Map<Integer, Integer> info = new HashMap<>();
        info.put(1, 2);
        info.put(2, 4);
        info.put(3, 7);
        return info;
    }

    private static Map<Integer, Integer> genDarkBlueInfo() {
        Map<Integer, Integer> info = new HashMap<>();
        info.put(1, 3);
        info.put(2, 8);
        return info;
    }

    private static Map<Integer, Integer> genLightBlueInfo() {
        Map<Integer, Integer> info = new HashMap<>();
        info.put(1, 1);
        info.put(2, 2);
        info.put(3, 3);
        return info;
    }

    private static Map<Integer, Integer> genRedInfo() {
        Map<Integer, Integer> info = new HashMap<>();
        info.put(1, 2);
        info.put(2, 3);
        info.put(3, 6);
        return info;
    }

    private static Map<Integer, Integer> genUtilityInfo() {
        Map<Integer, Integer> info = new HashMap<>();
        info.put(1, 1);
        info.put(2, 2);
        return info;
    }

    private static Map<Integer, Integer> genYellowInfo() {
        Map<Integer, Integer> info = new HashMap<>();
        info.put(1, 2);
        info.put(2, 4);
        info.put(3, 6);
        return info;
    }

    private static Map<Integer, Integer> genOrangeInfo() {
        Map<Integer, Integer> info = new HashMap<>();
        info.put(1, 1);
        info.put(2, 3);
        info.put(3, 5);
        return info;
    }

    private static Map<Integer, Integer> genBrownInfo() {
        Map<Integer, Integer> info = new HashMap<>();
        info.put(1, 1);
        info.put(2, 2);
        return info;
    }

    private static Map<Integer, Integer> genPurpleInfo() {
        Map<Integer, Integer> info = new HashMap<>();
        info.put(1, 1);
        info.put(2, 2);
        info.put(3, 4);
        return info;
    }

    private static Map<Integer, Integer> genRailroadInfo() {
        Map<Integer, Integer> info = new HashMap<>();
        info.put(1, 1);
        info.put(2, 2);
        info.put(3, 3);
        info.put(4, 4);
        return info;
    }
}
