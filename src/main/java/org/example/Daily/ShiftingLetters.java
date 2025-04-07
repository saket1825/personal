package org.example.Daily;

public class ShiftingLetters {

    public static String shiftLetters(String s, int[] shifts) {
        int size = shifts.length;
        for (int i = size - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1];
        }

        StringBuilder shiftedString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char append = (char) (((s.charAt(i) - 'a' + shifts[i]) % 26) + 'a');
            shiftedString.append(append);
        }
        return shiftedString.toString();
    }

    public static void main(String[] args) {
        int[] shifts = new int[]{1,2,3};
        System.out.println(shiftLetters("aaa", shifts));
        System.out.println(maximumWater(new int[]{1,8,20,2,5,4,8,20,7}));
        System.out.println(maximumWater(new int[]{1,1}));
    }

    public static int maximumWater(int[] heights){
        int maxWater = 0, start = 0, end = heights.length - 1;
        while (start < end) {
            maxWater = Math.max(maxWater, (end - start) * Math.min(heights[start], heights[end]));
            if (heights[start] > heights[end]) {
                end--;
            } else {
                start++;
            }
        }
        return maxWater;
    }
}
