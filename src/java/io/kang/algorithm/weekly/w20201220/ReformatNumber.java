package io.kang.algorithm.weekly.w20201220;

public class ReformatNumber {
    public static String reformatNumber(String number) {
        int len = number.length();
        StringBuilder builder = new StringBuilder();

        int n = 0;

        for(int i = 0; i < len; i++) {
            if (number.charAt(i) == ' ' || number.charAt(i) == '-') {
                continue;
            }
            builder.append(number.charAt(i));
        }

        String tmp = builder.toString();
        builder = new StringBuilder();

        for(int i = 1; i <= tmp.length(); i++) {
            if(i % 3 == 0) {
                builder.append(tmp.charAt(i-1));
                if(i == tmp.length()) break;
                builder.append("-");
            } else {
                builder.append(tmp.charAt(i-1));
            }
        }

        String result = builder.toString();

        if(builder.charAt(builder.length() - 2) == '-') {
            String str = "-" + builder.substring(builder.length()-3).replace("-", "");
            result = builder.substring(0, builder.length()-3) + str;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reformatNumber("4802066218-13110231308 "));
    }
}
