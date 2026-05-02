class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(isGood(i)){
               count++;
            }
        }
         return count;
    }
    public boolean isGood(int nums){
        boolean f=false;
        while(nums >0){
            int d=nums%10;
            if(d==3||d==4||d==7){
                return false;
            }
            if(d==2||d==5||d==6||d==9){
                f=true;
            }
             nums/=10;
        }
        return f;
    }

}