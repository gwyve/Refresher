package OJ.LeetCode.Num051_100;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yixina-z on 18/2/17.
 */
public class Num093RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<String>();
        if (s.length()>12)
            return ret;
        res(ret,"",s,0,1);
        return ret;
    }

    public void res(List<String> ret,String k, String s, int start, int index){
        if (index == 4){
            if (start > s.length()-1)
                return;
            if (s.charAt(start) == '0' && start+1 != s.length())
                return;
            int tmp = Integer.parseInt(s.substring(start));
            if (tmp<256)
                ret.add(k+tmp);
        }else {
            if (start+1 > s.length())
                return;
            int tmp = Integer.parseInt(s.substring(start,start+1));
            if (tmp<256){
                String k1 = k+tmp+".";
                res(ret,k1,s,start+1,index+1);
            }

            if (start+2 > s.length())
                return;
            if (s.charAt(start) == '0')
                return;
            tmp = Integer.parseInt(s.substring(start,start+2));
            if (tmp<256){
                String k2 = k+tmp+".";
                res(ret,k2,s,start+2,index+1);
            }

            if (start+3 > s.length())
                return;
            if (s.charAt(start) == '0')
                return;
            tmp = Integer.parseInt(s.substring(start,start+3));
            if (tmp < 256){
                String k3 = k+tmp +".";
                res(ret,k3,s,start+3,index+1);
            }
        }
    }

    public static void main(String[] args){
        Num093RestoreIPAddresses obj = new Num093RestoreIPAddresses();
        List<String> ret = obj.restoreIpAddresses("010010");
        Iterator<String> it = ret.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
