class Solution {
    public int minimumDeletions(String word, int k) {
// 1. We count the number of times each type of lollipop (character) occurs in a word
        int[] f = new int[26]; // Array for storing the frequencies of each character (a-z)
for (char c : word.toCharArray()) { // Going through each character in the word
            f[c - 'a']++; // Incrementing the counter for the corresponding character
        }

        // 2. We are looking for the least amount of lollipops that need to be removed
        int ans = Integer.MAX_VALUE; // The initial value of the response is "infinity" (the maximum possible value)

        // 3. Iterate over each type of lollipop (each character)
for (int i = 0; i < 26; i++) { // For each character from 'a' to 'z'
            if (f[i] == 0) continue; // If this type of lollipop is not present, skip
/*
it is important to remember that such conditions optimize the 
code very well and in this case it simply means that some 
character from the alphabet (‘a’ to ‘z’) does not 
occur at all in We skip the given word, so as not to waste time. 
*/

            int del = 0; // The number of lollipops that need to be removed if we "fix" this type of lollipop
            int cur = f[i]; // The number of lollipops of the current type

            // 4. Compare with other types of lollipops
            for (int j = 0; j < 26; j++) { // For every other character
                // 5. We count how many lollipops we need to remove
                if (f[j] < cur) { // If the number of lollipops is less than the "fixed" one
                    del += f[j]; // Removing all these lollipops
                } else if (Math.abs(f[j] - cur) > k) { // If the difference is greater than k
                    del += Math.abs(f[j] - cur) - k; // Removing part of the lollipops so that the difference becomes k
                }
            }

/*
❗❗We want to keep only those lollipops in the bag whose difference 
between the largest and smallest amount does not exceed k❗❗
*/

            // 6. We update the minimum number of lollipops
            ans = Math.min(ans, del); // If this option is better, memorize it

        }

        // 7. We are returning the response
        return ans; // We return the minimum number of lollipops that need to be removed.
    }
}