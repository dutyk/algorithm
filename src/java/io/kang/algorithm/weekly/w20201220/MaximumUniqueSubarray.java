package io.kang.algorithm.weekly.w20201220;

import java.util.ArrayList;
import java.util.List;

public class MaximumUniqueSubarray {
    public static int maximumUniqueSubarray(int[] nums) {
        int result = 0;

        int len = nums.length;

        List<Integer> tmpList = new ArrayList();

        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                if (!tmpList.contains(nums[j])) {
                    tmpList.add(nums[j]);
                } else {
                    int sumL = 0;
                    for (Integer in : tmpList) {
                        sumL += in;
                    }
                    result = Math.max(result, sumL);
                    tmpList.clear();
                    break;
                }
            }
        }
        int sumL = 0;
        for (Integer in : tmpList) {
            sumL += in;
        }
        result = Math.max(result, sumL);

        return result;

    }

    public int maximumUniqueSubarray1(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int i1 = 0;
        int i2 = 1;

        int result = Integer.MIN_VALUE;
        while(i2 <= n) {
            int ind = indexOf(nums, i1, i2);
            if(ind != -1) {
                int tmp = 0;
                for(int i = i1; i < i2; i++) {
                    tmp += nums[i];
                }
                result = Math.max(result, tmp);
                i1 = ind + 1;

                if(i2 < i1) i2 = i1 + 1;
            }else {
                i2++;
                if(i2 == n) {
                    int tmp = 0;
                    for(int i = i1; i < i2; i++) {
                        tmp += nums[i];
                    }
                    result = Math.max(result, tmp);
                }
            }
        }
        return result;
    }

    private int indexOf(int[] nums, int left, int right) {
        if(right >= nums.length) return -1;
        for(int i = left; i < right; i++) {
            if(nums[i] == nums[right]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumUniqueSubarray().maximumUniqueSubarray1(new int[]{187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434}));
        System.out.println(new MaximumUniqueSubarray().maximumUniqueSubarray1(new int[]{4,2,4,5,6}));
        System.out.println(new MaximumUniqueSubarray().maximumUniqueSubarray1(new int[]{5588,1245,4935,3453,6719,7990,1328,9228,1663,1483,2451,593,8055,3012,2837,7740,7191,4894,4708,5445,4515,154,7925,133,5636,8886,7891,8759,1498,8952,4032,7989,7645,8035,3017,9956,1035,2694,1076,2537,1677,2740,5680,4349,1154,9328,8506,2963,819,7500,3590,2420,8697,3920,7033,7984,210,2087,599,9655,1609,6657,926,6322,1897,553,3935,9093,5398,6366,8626,8242,6322,2029,7832,2269,8099,2867,3452,4763,8479,3199,7636,1005,6938,1209,6491,284,5040,8724,2487,7635,5120,631,8569,8962,9787,3244,2979,6189,9243,2788,6901,2279,9322,5322,7068,4861,6839,7969,6193,9974,2388,4335,422,4780,2317,3336,578,1792,3773,3528,9683,5668,9956,9731,6563,51,1605,806,3123,8035,4314,2602,3280,3268,968,3322,7204,2490,4464,1342,1252,6157,6523,1347,3427,2218,1434,9572,2064,8387,7968,4404,1841,90,2194,7466,1960,229,462,5615,624,8681,8652,247,4901,3201,1416,3221,9557,9573,910,3199}));

    }
}
