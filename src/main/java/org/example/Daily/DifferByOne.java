package org.example.Daily;

import java.util.*;

public class DifferByOne {
    public static String findString(String[] list) {
        if (list == null || list.length == 0) {
            return "";
        }
        int length = list[0].length();
        for (String s : list) {
            for (int i = 0; i < length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == s.charAt(i)) {
                        continue;
                    }
                    String candidate = s.substring(0, i) + c + s.substring(i + 1);

                    boolean isValid = true;
                    for (String str : list) {
                        if (countDifferences(candidate, str) > 1) {
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid) {
                        return candidate;
                    }
                }
            }
        }
        return "";
    }
    private static int countDifferences(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        String[] list = {"bcb", "zzz", "zzc"};
        String[] list = {"aaka", "aaka" ,"aaja" ,"aaxa" ,"aaba"};
        String result = findString(list);
        System.out.println("Result: " + result); // Output: "baz"
    }
}

