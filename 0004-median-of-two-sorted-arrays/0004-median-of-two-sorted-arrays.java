class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     int  m = nums1.length;
     int  n = nums2.length;

     int res[] = new  int[m+n];

     for(int i =0; i<m; i++){
        res[i] = nums1[i];
     } 

     for(int i =0; i< n; i++){
        res[m+i] = nums2[i];
     }  

     Arrays.sort(res);

     int len = res.length;

     if(len % 2 != 0){
        return res[len/2];
     }

     int mid1 = res[len/2-1];
     int mid2= res[len/2];

     return (mid1+ mid2) / 2.0;


    }
}