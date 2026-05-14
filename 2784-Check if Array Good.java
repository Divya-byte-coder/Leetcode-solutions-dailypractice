class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length-1;
        int[]count=new int[256];
        for(int num:nums){
            count[num]++;
        }
        if(count[n]!=2){
               return false;
        }
        for(int i=1;i<n;i++){
            if(count[i]!=1){
                return false;
            }
        }
        return true;
    }
}