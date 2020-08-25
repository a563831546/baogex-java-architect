package com.baogex.algorithm.offer;

/**
 * <p>
 * 将一个字符串中的空格替换成 "%20"。
 *  打印链表
 * Input:
 * "A B"
 *
 * Output:
 * "A%20B"
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-24
 */
public class ReplaceSpaces {
    public static StringBuffer test=new StringBuffer("A B ");
    public static String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 >= P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        System.out.println(replaceSpace(test));
    }
}
