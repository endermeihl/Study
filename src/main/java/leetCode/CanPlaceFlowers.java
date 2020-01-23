package leetCode;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==1){
                continue;
            }else{
                if(i==0 && i+1==flowerbed.length){
                    n--;
                    flowerbed[i]=1;
                }else if(i==0 && flowerbed[i+1]!=1){
                    n--;
                    flowerbed[i]=1;
                }else if(flowerbed[i-1]!=1 && i+1==flowerbed.length){
                    n--;
                    flowerbed[i]=1;
                }else{
                    n--;
                    flowerbed[i]=1;
                }
            }
        }
        return n==0;
    }
}
