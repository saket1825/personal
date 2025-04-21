package org.example.Daily;

public class LC38 {


    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String prevAns = countAndSay(n - 1);
            return findAns(prevAns);
        }
    }

    public String findAns(String prev) {
        char[] arr = prev.toCharArray();
        StringBuilder ans = new StringBuilder();
        char prevChar = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (prevChar != arr[i]) {
                ans.append(count);
                ans.append(prevChar);
                count = 1;
                prevChar = arr[i];
            } else {
                count++;
            }

        }
        return ans.toString();
    }
}
