class Solution {
    int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // Sort to enable two pointer traversal

        // Precompute powers of 2 up to n
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1, ans = 0;

        // Two pointers: shrink window from both sides
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // All subsequences from left to right are valid
                ans = (ans + power[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}