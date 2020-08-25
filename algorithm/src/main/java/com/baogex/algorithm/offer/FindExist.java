package com.baogex.algorithm.offer;

/**
 * <p>
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-24
 */
public class FindExist {
    public static boolean find(int[][] bases, int findNum) {
        if (bases == null || bases.length == 0 || bases[0].length == 0 ||
                findNum > bases[bases.length - 1][bases[0].length - 1]) {
            return false;
        }
        int maxR = bases.length;
        int maxC = bases[0].length;
        int r = maxR - 1, c = 0;
        while (r > -1 && c < maxC) {
            if (bases[r][c] == findNum) {
                return true;
            } else {
                if (findNum < bases[r][c]) {
                    r--;
                } else {
                    c++;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] base = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(find(base, 50));
    }
}
