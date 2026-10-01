class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void solve(int[] nums, int index, List<Integer> current,
                      List<List<Integer>> ans) {

        ans.add(new ArrayList<>(current));

        int i = index;

        while (i < nums.length) {

            if (i > index && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            current.add(nums[i]);
            solve(nums, i + 1, current, ans);
            current.remove(current.size() - 1);

            i++;
        }
    }
}