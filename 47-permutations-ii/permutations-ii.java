import java.util.*;
class Solution {
    public static void helper(List<List<Integer>> mainlist, List<Integer> list, boolean[] track, int[] nums, Set<List<Integer>> set) {
        if (nums.length == list.size()) {
            List<Integer> ll = new ArrayList<>(list); // Copy current permutation
            if (!set.contains(ll)) { // Add only unique permutations
                mainlist.add(ll);
                set.add(ll);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!track[i]) { // Check if element is already used
                list.add(nums[i]); // Add element to current permutation
                track[i] = true; // Mark as used
                helper(mainlist, list, track, nums, set); // Recursive call
                track[i] = false; // Backtrack to explore other paths
                list.remove(list.size() - 1); // Remove last added element
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> mainlist = new ArrayList<>(); // To store unique permutations
        List<Integer> list = new ArrayList<>(); // Temporary list for permutations
        boolean[] track = new boolean[nums.length]; // Tracking usage of elements
        helper(mainlist, list, track, nums, new HashSet<>()); // Call the helper function
        return mainlist; // Return the list of unique permutations
    }
}