package OJ.LeetCode.Num151_200;

public class Num164MaximumGap {
    public int maximumGap(int[] nums) {
        // 这里用的是桶排序，需要注意到最大差不小于（max-min)/(nums.length-1)

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int val:nums){
            max = max>val?max:val;
            min = min<val?min:val;
        }
        if(max==min)
            return 0;
        if (nums.length<2)
            return 0;
        if (nums.length == 2)
            return max-min;
        int len = (int) Math.ceil(((double)max-min)/(nums.length-1));
        int n = (max-min)/len;

        int[] minBucket = new int[n+1];
        int[] maxBucket = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            minBucket[i] = Integer.MAX_VALUE;
            maxBucket[i] = Integer.MIN_VALUE;
        }
        for(int val :nums){
            int t = (val-min)/len;
            minBucket[t] = minBucket[t]<val?minBucket[t]:val;
            maxBucket[t] = maxBucket[t]>val?maxBucket[t]:val;
        }
        int res = len;
        int pre = maxBucket[0];
        for (int i = 1; i < n+1; i++) {
            if (minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE)
                continue;
            int diff = minBucket[i] - pre;
            res = res>diff?res:diff;
            pre = maxBucket[i];
        }
        return res;

    }
    public static void main(String[] args){
        Num164MaximumGap obj = new Num164MaximumGap();
        System.out.println(obj.maximumGap(new int[]{15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740}));
    }
}