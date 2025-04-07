package org.example.Daily;

public class UniqueStringFinder {
    public static String findString(String[] list) {
        int length = list[0].length();

        for (int i = 0; i < length; i++) {
            for (char c = 'a'; c <= 'z'; c++) { // Iterate through lowercase letters
                StringBuilder candidate = new StringBuilder(list[0]);
                candidate.setCharAt(i, c);

                if (isValid(candidate.toString(), list)) {
                    return candidate.toString();
                }
            }
        }
        return ""; // Return empty string if no valid string is found
    }

    private static boolean isValid(String candidate, String[] list) {
        for (String s : list) {
            if (getDifferenceCount(candidate, s) > 1) {
                return false;
            }
        }
        return true;
    }

    private static int getDifferenceCount(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) return count; // No need to count further if >1
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] list = {"bay", "zaz", "bab"};
        String result = findString(list);
        System.out.println("Result: " + result);
    }
}

