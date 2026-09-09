class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=prices[0];
        int profit=-1;
        for(int i=0;i<n;i++){
            profit=Math.max(profit,prices[i]-buy);
            if(buy>prices[i]) buy=prices[i];
        }
        return (profit==-1)?0:profit;
    }
}