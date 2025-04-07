package org.example.Daily;

public class SingleElementFinder {
    public static int findUniqueElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == arr[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 3, 3, 7, 7, 11, 11}; // Unique element = 10
        int[] arr2 = {1, 1, 2, 2, 3, 4, 4};    // Unique element = 3
        int[] arr3 = {5, 5, 8, 8, 9};          // Unique element = 9

        System.out.println("Unique Element: " + findUniqueElement(arr1)); // Output: 10
        System.out.println("Unique Element: " + findUniqueElement(arr2)); // Output: 3
        System.out.println("Unique Element: " + findUniqueElement(arr3)); // Output: 9
    }
}
