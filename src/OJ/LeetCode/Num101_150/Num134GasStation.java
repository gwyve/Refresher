package OJ.LeetCode.Num101_150;

public class Num134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost== null)
            return -1;
        if (gas.length!=cost.length || gas.length == 0)
            return -1;

        for (int i = 0; i < gas.length; i++) {
            if (travel(gas,cost,i))
                return i;
        }
        return -1;

    }
    public boolean travel(int[] gas, int[] cost , int start){
        int left = 0;
        for (int i = 0; i < gas.length; i++) {
            int index = (start+i)%gas.length;
            left += gas[index];
            left -= cost[index];
            if (left<0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Num134GasStation obj = new Num134GasStation();
        System.out.println(obj.canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
    }
}