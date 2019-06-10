package OJ.LeetCode.Num151_200;

public class Num167TwoSumIIInputarrayissorted {

    public int[] twoSum1(int[] numbers, int target){
        // 主要是排序之后的数组
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length-1;
        while (left!=right){
            if (numbers[left] + numbers[right]<target){
                left++;
            }else if (numbers[left] + numbers[right] > target){
                right--;
            }else {
                res[0] = left+1;
                res[1] = right+1;
                break;
            }
        }
        return res;
    }


    public int[] twoSum(int[] numbers, int target) {
        // n平方的傻瓜方法
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j <numbers.length ; j++) {
                if (numbers[i]+numbers[j] == target){
                    res[0] = i+1;
                    res[1] = j+1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Num167TwoSumIIInputarrayissorted obj = new Num167TwoSumIIInputarrayissorted();
        System.out.println(obj.twoSum1(new int[]{2,7,9,15},9));
    }
}