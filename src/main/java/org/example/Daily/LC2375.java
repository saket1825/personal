package org.example.Daily;

import java.util.Stack;

public class LC2375 {

    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= pattern.length(); i++) {
            st.push(i + 1);
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
            }
        }
        return sb.toString();
    }
}
