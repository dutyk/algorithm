package io.kang.algorithm.weekly.w20201115;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//5603. 确定两个字符串是否接近
public class Solution2 {
    public static boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if(m != n) return false;

        int[] occurs1 = new int[26];
        int[] occurs2 = new int[26];

        List<String> dig1 = new ArrayList<>();
        List<String> dig2 = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int pos1 = word1.charAt(i) - 'a';
            int pos2 = word2.charAt(i) - 'a';
            occurs1[pos1] = occurs1[pos1] + 1;
            occurs2[pos2] = occurs2[pos2] + 1;
            if(!dig1.contains(word1.charAt(i)+"")) {
                dig1.add(word1.charAt(i)+"");
            }

            if(!dig2.contains(word2.charAt(i)+"")) {
                dig2.add(word2.charAt(i)+"");
            }
        }

        if(dig1.size() != dig2.size()) return false;

        dig1.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        dig2.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(int i = 0; i < dig1.size(); i++) {
            if(!dig1.get(i).equals(dig2.get(i))) return false;
        }

        Arrays.sort(occurs1);
        Arrays.sort(occurs2);


        boolean isMatchCon1 = true;
        for(int i = 25; i >= 0; i--) {
            if(occurs1[i] != occurs2[i]) {
                isMatchCon1 = false;
                break;
            }
        }

        if(isMatchCon1) return true;


        return false;
    }
    public static void main(String[] args) {
        System.out.println(closeStrings("uau", "ssx"));
    }
}
