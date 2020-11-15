package io.kang.algorithm.weekly.w20201115;

//5602. 将 x 减到 0 的最小操作数
public class Solution3 {
    public static int minOperations(int[] nums, int x) {
        return digui(nums, 0, nums.length, x);
    }

    public static int digui(int[] nums, int start, int stop, int x) {
        int len = stop - start;

        if(len < 0) return -1;

        int result = Integer.MAX_VALUE;

        //left
        int m = x - nums[start];
        if(m == 0) return 1;
        int end = -1;

        for(int i = start + 1; i < stop - 1; i++) {
            if(m == 0){
                return i - start + 1;
            }else if(m < 0) {
                break;
            }else if(m > 0) {
                m -= nums[i];
                if(m == 0) {
                    result = Math.min(result, i-start+1);
                    break;
                }
            }
        }

        // right
        m = x - nums[stop-1];
        end = stop;
        if(m == 0) return 1;

        for(int i = stop-2; i >= 1; i--) {
            if(m == 0){
                return end - i;
            }else if(m < 0) {
                break;
            }else if(m > 0) {
                m -= nums[i];
                if(m == 0) {
                    result = Math.min(end - i, result);
                    break;
                }
            }
        }
        //left and right
        if(len < 2) return -1;
        m = x - nums[start] - nums[stop - 1];
        if(m == 0) return Math.min(result, 2);
        if(m < 0) {
            if(result != Integer.MAX_VALUE) return result;
            return -1;
        }
        if(len == 2) return -1;

        int r = digui(nums, start + 1, stop -1, m);

        if(r == -1) {
            if(result != Integer.MAX_VALUE) return result;
            return -1;
        }
        else return Math.min(result, r + 2);
    }

    public static int minOperations1(int[] nums, int x) {
        int n = nums.length;
        int[] ls = new int[n+1];
        int[] rs = new int[n+1];

        for(int i = 0; i < n; i++) {
            ls[i+1] = ls[i] + nums[i];
            rs[i+1] = rs[i] + nums[n - i - 1];
        }
        if (rs[n] < x) return -1;
        int result = n + 1;
        int l = n;

        for(int i = 0; i <= n; i++) {
            while(ls[i] + rs[l] > x && l > 0) {
                l--;
            }

            if(ls[i]+rs[l] == x) {
                result =  Math.min(result, i+l);
            }
        }

        if(result == n+1) return -1;
        return result;
    }

    public static void main(String[] args) {
        //2
        System.out.println(minOperations1(new int[]{5,2,3,1,1},  5));

        //-1
        System.out.println(minOperations1(new int[]{5,6,7,8,9},  4));

        //5
        System.out.println(minOperations1(new int[]{3,2,20,1,1,3},  10));

        //-1
        System.out.println(minOperations1(new int[]{1,1},  3));

        //2
        System.out.println(minOperations1(new int[]{3,2,20,1,1,3},  5));
        //1
        System.out.println(minOperations1(new int[]{1,1,3,2,5},  5));

        //28
        System.out.println(minOperations1(new int[]{5281,4109,5962,1122,8456,7256,9646,1708,7754,3164,8637,3769,5311,3714,2661,3807,5270,2026,164,2510,9151,9796,2563,5234,297,2883,5931,8937,9729,5201,9954,6776,5631,2966,1316,3999,2302,8014,7120,4012,9610,6541,7009,3438,9722,4564,9361,5800,5404,9304,1483,882,9834,2592,8812,371,7574,8236,2698,7254,4212,9254,5228,9219,5310,6896,1693,9635,1544,5751,7346,4104,4867,977,4988,5981,1644,7039,5808,8544,8961,2364,6156,6468,6357,4003,5106,261,3490,7859,2876,9116,3955,1218,2598,5866,1613,3737,8047,8483,2450,9009,9806,8432,8006,616,4519,2180,9641,9988,9151,1902,7002,8397,7355,9236,2302,5218,7151,3728,3118,8120,1728,2963,3588,4535,1953,2923,9496,7013,1692,6697,4962,862,3406,3484,9902,3031,6706,4025,6850,5257,7176,6724,1669,6801,9857,8702,1430,8299,3070,5729,3496,9443,6430,5988,7419,4436,9946,7153,6561,9938,6154,8614,1181,9708,2362,7881,9043,1703,5874,1257,5929,5729,606,8534,7245,8213,8227,2170,6374,2483,2111,4013,440,6240,6458,3812,15,7167,7967,1863,3034,742,7945,1412,8673,6499,8897,4716,816,4596,5337,8502,8974,690,9339,2095,4330,7884,8226,6108,8752,8657,1547,7796,4552,1913,3445,9278,5373,7569,1569,4422,2732,2833,5756,7402,1034,8197,8275,5748,8535,6599,2872,9128,3,9739,8336,2451,189,3264,878,504,2119,4518,2771,4082,6175,4135,5465,8331,7940,2665,6176,7136,5674,4746,6348},  151230));

    }
}
