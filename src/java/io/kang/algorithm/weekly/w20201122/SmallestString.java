package io.kang.algorithm.weekly.w20201122;

/**
 * 5606. 具有给定数值的最小字符串
 */
public class SmallestString {
    public static String getSmallestString(int n, int k) {
        StringBuilder str = new StringBuilder();

        int m = k / 26;

        int k1 = k - 26 * m;
        int k2 = n - m;

        if(k1 == 0 && k2 == 0) {
            for(int i = 0; i < m; i++) {
                str.append("z");
            }
            return str.toString();
        }

        if(k1 < k2) {
            for(int i = 0; i < k1; i++) {
                str.append("a");
            }

            int i = 1;
            int tmp1 = 0;
            for(i = 1; i <= k2 - k1; i++) {
                str.append("a");
                tmp1++;
                if(tmp1 % 26 == 0) {
                    m--;
                    tmp1 = 1;
                    str.append("a");
                }
            }

            char ch = (char)('z' - tmp1);
            str.append(ch);
            for(i = 0; i < m -1; i++) {
                str.append("z");
            }
            return str.toString();

        }else {
            for(int i = 0; i < k2 - 1; i++) {
                str.append("a");
            }
            char ch = (char)('a' + (k1 - k2));
            str.append(ch);
            for(int i = 0; i < m; i++) {
                str.append("z");
            }
            return str.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(getSmallestString(3, 27));
        System.out.println(getSmallestString(5, 73));

        System.out.println(getSmallestString(23100, 567226).length());
    }
}
