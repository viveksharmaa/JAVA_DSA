class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length && n>0; i++){
            if(flowerbed[i] == 0){
                int left;
                int right;
                if(i==0){
                    left = 0;
                }else{
                    left = flowerbed[i -1];
                }
                if(i == flowerbed.length-1){
                    right= 0;
                }else{
                    right = flowerbed[i+1];
                }
                if(left == 0 && right == 0){
                    flowerbed[i] =1;
                    n--;
                }
            }
        }
        return n==0;
    }
}