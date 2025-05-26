class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] col = new int[n];
        for (int i = 0; i < n; i++) col[i] = colors.charAt(i) - 'a';
        int[] outdeg = new int[n];  // Build primitive adjacency
        for (int[] e : edges) outdeg[e[0]]++;
        int[][] adj = new int[n][];
        for (int i = 0; i < n; i++) adj[i] = new int[outdeg[i]];
        int[] ptr = new int[n];
        int[] indeg = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj[u][ptr[u]++] = v;
            indeg[v]++;
        }
        int[][] dp = new int[n][26]; // dp table & ringbuffer queue
        int[] queue = new int[n];
        int qh = 0, qt = 0;
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                dp[i][col[i]] = 1;
                queue[qt++] = i;
            }
        }
        int seen = 0, ans = 0;
        while (qh < qt) {
            int u = queue[qh++];
            seen++;
            for (int c = 0; c < 26; c++) { // accumulate answer
                if (dp[u][c] > ans) ans = dp[u][c];
            }
            for (int v : adj[u]) { // relax edges
                int cv = col[v];
                int[] dpu = dp[u], dpv = dp[v];
                for (int c = 0; c < 26; c++) {
                    int val = dpu[c] + (c == cv ? 1 : 0);
                    if (val > dpv[c]) dpv[c] = val;
                }
                if (--indeg[v] == 0) {
                    queue[qt++] = v;
                }
            }
            dp[u] = null; // free this row
        }
        return seen == n ? ans : -1;
    }
}