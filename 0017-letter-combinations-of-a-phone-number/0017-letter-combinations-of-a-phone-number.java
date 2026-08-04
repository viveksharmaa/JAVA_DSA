class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result  = new ArrayList<>();
        if(digits.length()==0){
            return result;
        }

        String[] phone = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", result, phone);   //"23", idx=0, current=0, 0 or ["ad"], phone map
        return result;
    }

    private void backtrack(
        String digits,
        int index,
        String current,
        List<String> result,
        String[] phone
    ){
        if(index == digits.length()){
            result.add(current);
            return;
        }
        int digit = digits.charAt(index) - '0';// '2' - 2
        String letters = phone[digit];//phone[2] = "abc"
        for(char ch : letters.toCharArray()){   // a, b, c -> ch = 'a'
            backtrack(
                digits,
                index + 1,
                current + ch,
                result,
                phone
            );
        }
    }
}