class Solution {
    public int totalNumbers(int[] digits) {
        int count=0;
        
        for(int i=100;i<999;i+=2){
            int n=i;
            int d1=n%10;
            int d2=(n/10)%10;
            int d3=(n/100)%10;
            boolean df1=false,df2=false,df3=false;
            int [] freq=new int[n];
            for(int a:digits) freq[a]++;
            if(freq[d1]>0){
                df1=true;
                freq[d1]--;
            }
            if(freq[d2]>0){
                df2=true;
                freq[d2]--;
            }
            if(freq[d3]>0){
                df3=true;
                freq[d3]--;
            }
            if(df1 && df2 && df3) count++;
        }
        return count;
    }
}