class Solution {
    public int integerBreak(int n) {
        int [] dp=new int[n+1];
        switch(n){
            case 2: return 1;
            case 3: return 2;
            case 4: return 4;
            case 5: return 6;
            case 6: return 9;
        }
        dp[2]=1;
        dp[3]=2;
        dp[4]=4;
        dp[5]=6;
        dp[6]=9;
        for(int i=7;i<=n;i++){
            if(i%3==0) dp[i]=(dp[i-1]/2)*3;
            if(i%3==1) dp[i]=(dp[i-1]/3)*4;
            if(i%3==2) dp[i]=(dp[i-2])*2;
        }
        return dp[n];

    }
}