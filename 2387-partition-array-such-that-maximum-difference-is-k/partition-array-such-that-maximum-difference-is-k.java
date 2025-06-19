class Solution {
    public int partitionArray(int[] nums, int k) {
        // 1. First, let's sort the array! Think of it as organizing your cards before playing a game. \U0001f3b4
        Arrays.sort(nums);

        // 2. Get the length of the array. It's like counting how many cards you have. \U0001f522
        int count = 0, start = 0;

        // 3. Loop through each number in the sorted array. \U0001f6b6‍♀️
        for (int i = 0; i < nums.length; i++) {
            // 4. Check if the difference between the current number and the start of our subsequence is too big (greater than k). \U0001f914
            if (nums[i] - nums[start] > k) {
                // 5. If the difference is too big, it means we need a new subsequence! \U0001f389
                count++; // Increment the subsequence count.
                start = i; // Update the start index to the current number.
            }
        }

        // 6. Don't forget to count the last subsequence! We always need to count the last group. \U0001f381
        count++;

        // 7. Return the total number of subsequences. That's the answer! \U0001f3c6
        return count;
    }
}