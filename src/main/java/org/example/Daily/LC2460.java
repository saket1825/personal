package org.example.Daily;

public class LC2460 {
    public int[] applyOperations(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                if (i != zeroIndex) {
                    int temp = nums[zeroIndex];
                    nums[zeroIndex] = nums[i];
                    nums[i] = temp;
                }
                zeroIndex++;
            }
        }
        return nums;
    }
}
