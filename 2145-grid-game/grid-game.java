class Solution {
    public long gridGame(int[][] grid) {
        int m = grid[0].length;
        long[] pref1 = new long[m];
        long[] pref2 = new long[m];

        pref1[0] = grid[0][0];
        pref2[0] = grid[1][0];

        for (int i = 1; i < m; i++) {
            pref1[i] = pref1[i - 1] + grid[0][i];
            pref2[i] = pref2[i - 1] + grid[1][i];
        }

        long result = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            long top = (i == m - 1) ? 0 : pref1[m - 1] - pref1[i];
            long bottom = (i == 0) ? 0 : pref2[i - 1];
            result = Math.min(result, Math.max(top, bottom));
        }

        return result;
    }
}