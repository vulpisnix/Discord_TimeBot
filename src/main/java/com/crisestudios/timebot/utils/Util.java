package com.crisestudios.timebot.utils;

public class Util {
    public static String[] dropArray(int amount, String[] array) {
        String[] arr = new String[array.length-amount];
        for(int i = amount; i < array.length; i++) {
            arr[i-amount] = array[i];
        }
        return arr;
    }
}
