class Solution {
    public int maxProfit(int[] prices) {
         int lp = 0;
        int rp = 1;
        int maxprofit = 0;
        while(rp < prices.length){
            if(prices[rp] > prices[lp]){
                int profit = prices[rp] - prices[lp];
                maxprofit = Math.max(maxprofit , profit);
            }else{
                lp = rp;
            }
            rp++;
        }
        return maxprofit;
    }
}