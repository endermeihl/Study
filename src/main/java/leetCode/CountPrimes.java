package leetCode;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {
    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        if(n<3){
            return 1;
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(2);
        for(int i=3;i<n;i++){
            boolean isPrimes=true;
            for (Integer integer : temp) {
                if (i % integer == 0) {
                    isPrimes = false;
                    break;
                }
            }
            if(isPrimes){
                temp.add(i);
            }
        }
        return temp.size();
    }
    public static void main(String[] args){
        CountPrimes countPrimes=new CountPrimes();
        countPrimes.countPrimes(20);
    }
}
