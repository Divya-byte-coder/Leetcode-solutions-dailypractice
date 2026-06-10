class Solution {
    int[][] mx, mn;
    int[] lg;

    private long value(int l, int r) {
        int k = lg[r - l + 1];
        int max = Math.max(mx[l][k], mx[r - (1 << k) + 1][k]);
        int min = Math.min(mn[l][k], mn[r - (1 << k) + 1][k]);
        return (long) max - min;
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) lg[i] = lg[i / 2] + 1;

        int m = lg[n] + 1;
        mx = new int[n][m];
        mn = new int[n][m];

        for (int i = 0; i < n; i++) {
            mx[i][0] = mn[i][0] = nums[i];
        }

        for (int j = 1; j < m; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                mx[i][j] = Math.max(mx[i][j - 1],
                        mx[i + (1 << (j - 1))][j - 1]);
                mn[i][j] = Math.min(mn[i][j - 1],
                        mn[i + (1 << (j - 1))][j - 1]);
            }
        }

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        for (int l = 0; l < n; l++)
            pq.offer(new long[]{value(l, n - 1), l, n - 1});

        long ans = 0;

        while (k-- > 0) {
            long[] cur = pq.poll();
            ans += cur[0];

            int l = (int) cur[1];
            int r = (int) cur[2];

            if (r > l)
                pq.offer(new long[]{value(l, r - 1), l, r - 1});
        }

        return ans;
    }
}