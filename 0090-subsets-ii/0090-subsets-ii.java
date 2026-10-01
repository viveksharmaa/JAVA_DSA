class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        Arrays.sort(nums);
        solve(nums, index, new ArrayList<>(), ans);
        return ans;
    }

    public void solve(int[] nums, int index, List<Integer> current, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            solve(nums, i + 1, current, ans);
            current.remove(current.size() - 1);
        }
    }
}