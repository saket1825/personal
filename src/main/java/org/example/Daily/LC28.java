package org.example.Daily;

public class LC28 {
    public static int strStr(String haystack, String needle) {
        int[] lps = getPatternLps(needle);
        int j = 0, i = 0;
        for (; i < haystack.length(); i++) {
            // System.out.println(i+" "+j+" ");
            if (j == needle.length()) {
                return i-needle.length();
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                if(j>0){
                    j = lps[j - 1];
                    i--;
                }
            }
        }
        return j== needle.length()? i-needle.length():-1;
    }

//    private static int[] getPatternLps(String needle) {
//        int n = needle.length(), i = 0, j = 1;
//        int[] lps = new int[n];
//
//        for (; j < n; j++) {
//            i = lps[j-1];
//            while(i>0 && needle.charAt(i) != needle.charAt(j)){
//                i = lps[i-1];
//            }
//            if(needle.charAt(i) == needle.charAt(j)){
//                i++;
//            }
//            lps[j] = i;
//        }
//        return lps;
//    }

    private static int[] getPatternLps(String s) {
        int n = s.length(), i = 1, j = 0;
        int[] lps = new int[n];

        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                lps[i++] = j;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                    lps[i] = j;
                } else {
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        strStr("kmpkmpkmdtu", "kmpkmpkmdtu");
    }
}
