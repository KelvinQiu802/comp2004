package model;

import java.util.HashMap;
import java.util.Map;

public class PropertyInfo {
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

    public static Map<Integer, Integer> getGreen() {
        return new HashMap<>(green);
    }

    public static Map<Integer, Integer> getDarkBlue() {
        return new HashMap<>(darkBlue);
    }

    public static Map<Integer, Integer> getLightBlue() {
        return new HashMap<>(lightBlue);
    }

    public static Map<Integer, Integer> getRed() {
        return new HashMap<>(red);
    }

    public static Map<Integer, Integer> getUtility() {
        return new HashMap<>(utility);
    }

    public static Map<Integer, Integer> getYellow() {
        return new HashMap<>(yellow);
    }

    public static Map<Integer, Integer> getOrange() {
        return new HashMap<>(orange);
    }

    public static Map<Integer, Integer> getBrown() {
        return new HashMap<>(brown);
    }

    public static Map<Integer, Integer> getPurple() {
        return new HashMap<>(purple);
    }

    public static Map<Integer, Integer> getRailroad() {
        return new HashMap<>(railroad);
    }
}
