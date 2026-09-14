class Solution {
    public boolean isRectangleOverlap(int[] rect1, int[] rect2) {
        int[][] xinterval=new int[2][2];
        int[][] yinterval=new int[2][2];
        xinterval[0]=new int[]{rect1[0],rect1[2]};
        xinterval[1]=new int[]{rect2[0],rect2[2]};
        yinterval[0]=new int[]{rect1[1],rect1[3]};
        yinterval[1]=new int[]{rect2[1],rect2[3]};
        Arrays.sort(xinterval,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(yinterval,(a,b)->Integer.compare(a[0],b[0]));
        if(xinterval[0][1]>xinterval[1][0] && yinterval[0][1]>yinterval[1][0]) return true;
        return false;
    }
}