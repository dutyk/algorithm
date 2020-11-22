package io.kang.algorithm.weekly.w20201122;

/**
 * 5607. 生成平衡数组的方案数
 */
public class WaysToMakeFair {
    public int waysToMakeFair(int[] nums) {
        int count = 0;

        int sum0 = 0;
        int sum1 = 0;
        for(int i = 0; i < nums.length; i++) {
           if((i&1) == 0) sum0+=nums[i];
           else sum1 += nums[i];
        }

        int sum00 = 0;
        int sum01 = 0;
        for(int i = 0; i < nums.length; i++) {
            if((i&1) == 0) {
                sum0 -= nums[i];
            }else {
                sum1 -= nums[i];
            }

            if(sum0 + sum01 == sum1 + sum00) count++;

            if((i&1) == 0) {
                sum00 += nums[i];
            }else {
                sum01 += nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new WaysToMakeFair().waysToMakeFair(new int[]{2,1,6,4}));
        System.out.println(new WaysToMakeFair().waysToMakeFair(new int[]{1,1,1}));

    }
}
