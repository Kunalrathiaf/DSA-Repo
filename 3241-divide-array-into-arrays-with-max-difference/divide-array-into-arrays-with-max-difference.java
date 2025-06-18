class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // 1. Sort the LEGO bricks! \U0001f9f1 -> \U0001f9f1\U0001f9f1\U0001f9f1 (smallest to largest)
        Arrays.sort(nums);
        int n = nums.length;

        // 2. Let's get the number of packs. If it's not divisible by 3, it's a no-go. \U0001f6ab
        //    It's like trying to make a triangle with only two sides - impossible!
        int[][] arr = new int[n / 3][3];

        // 3. Loop through the sorted bricks, making packs of 3. \U0001f4e6\U0001f4e6\U0001f4e6
        //    It's like assembling the LEGO sets, one after the other!
        for (int i = 0; i < n; i += 3) {
            // 4. Check if the largest and smallest bricks in the pack are too different. \U0001f4cf
            //    If the difference is too big, we can't make a valid pack! \U0001f494
            if (nums[i + 2] - nums[i] > k) return new int[0][]; //Empty Array Means Impossible

            // 5. Fill the packs! \U0001f9f1 -> \U0001f4e6
            //    Putting those bricks into their assigned spots.
            arr[i / 3][0] = nums[i];
            arr[i / 3][1] = nums[i + 1];
            arr[i / 3][2] = nums[i + 2];
        }

        // 6. All packs are ready! \U0001f389 Let's ship them off. \U0001f69a
        return arr;
    }
}