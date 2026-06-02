class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            int landEnd = landStartTime[i] + landDuration[i];
            for (int j = 0; j < waterStartTime.length; j++) {
                int waterStart = Math.max(landEnd, waterStartTime[j]);
                ans = Math.min(ans, waterStart + waterDuration[j]);
            }
        }
        for (int i = 0; i < waterStartTime.length; i++) {
            int waterEnd = waterStartTime[i] + waterDuration[i];
            for (int j = 0; j < landStartTime.length; j++) {
                int landStart = Math.max(waterEnd, landStartTime[j]);
                ans = Math.min(ans, landStart + landDuration[j]);
            }
        }
        return ans;
    }
}