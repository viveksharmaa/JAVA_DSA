class Solution {
    public int romanToInt(String s) {
        int val = 0; 

        for(int  i = 0; i< s.length() ; i++){
            int  ch  =  solve(s.charAt(i));

            if (i < s.length()-1 && ch < solve(s.charAt(i+1))){
                val -= ch; 
            } else {
                val += ch; 
            }

        }
        return val;
    }
      public int solve (char num){
        if(num == 'I') return 1;
        if(num == 'V') return 5;
        if(num == 'X') return 10;
        if(num == 'L') return 50;
        if(num == 'C') return 100;
        if(num == 'D') return 500;
        if(num == 'M') return 1000;
        return 0;
    }
}