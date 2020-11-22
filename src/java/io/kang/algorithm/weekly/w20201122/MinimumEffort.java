package io.kang.algorithm.weekly.w20201122;

import java.util.ArrayList;
import java.util.List;

/**
 * 5608. 完成所有任务的最少初始能量
 */
public class MinimumEffort {

    private int minEffort = 0;

    public int minimumEffort(int[][] tasks) {
        int len = tasks.length;
        int minEffort = 0;
        List<Integer> efforts = new ArrayList<>();
        List<Integer> minEfforts = new ArrayList<>();

        for(int i = 0; i < len; i++) {
            this.minEffort += tasks[i][0];
            efforts.add(tasks[i][0]);
            minEfforts.add(tasks[i][1]);
        }

        int minEffort1 = this.minEffort;
        digui(minEffort1, efforts, minEfforts);

        return this.minEffort;
    }

    private void digui(int minEffort, List<Integer> efforts, List<Integer> minEfforts) {
        if(efforts == null || efforts.size() == 0) return;

        int maxE = minEfforts.stream().min(Integer::compareTo).get();

        if(minEffort < maxE) {
            minEffort = maxE;
            this.minEffort += maxE - minEffort;
        }

        int i = minEfforts.indexOf(maxE);
        efforts.remove(i);
        minEfforts.remove(i);
        digui(minEffort - efforts.get(i), efforts, minEfforts);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumEffort().minimumEffort(new int[][]{{1,3}, {2,4}, {10,11}, {10,12},{8,9}}));
    }
}
