package OJ.LeetCode.Num151_200;

import java.util.HashMap;
import java.util.Map;

public class Num169MajorityElement {
    public int majorityElement1(int[] nums) {
        // 这个方法很神奇，找到两个不一样的就count --；
        int count = 0;
        int element = nums[0];
        for(int val:nums){
            if (count == 0){
                element = val;
                count++;
            }else {
                if (element == val){
                    count ++;
                }else {
                    count --;
                }
            }
        }
        return element;

    }
    public int majorityElement(int[] nums) {
        // 虽然这个只有n的复杂度，可是速度也不快
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int res = nums[0];
        for(int val:nums){
            if (map.containsKey(val)){
                map.put(val,map.get(val)+1);
                if (map.get(val)>nums.length/2){
                    res = val;
                    break;
                }
            }else {
                map.put(val,1);
            }
        }
        return res;
    }
    public static void main(String[] args){
        Num169MajorityElement obj = new Num169MajorityElement();
        System.out.println(obj.majorityElement1(new int[]{1,2,2}));
    }

}