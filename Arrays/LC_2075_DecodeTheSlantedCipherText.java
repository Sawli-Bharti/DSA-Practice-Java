/*
    https://leetcode.com/problems/decode-the-slanted-ciphertext/description/?envType=daily-question&envId=2026-04-04


    Approach: Simulation
    Time complexity O(n) where n is the length of encodedText string

    logic: we can create a matrix of rows and cols and fill it with the characters of encodedText string. Then we can traverse the matrix in a diagonal manner and append the characters to a StringBuilder. Finally, we can remove the trailing spaces from the StringBuilder and return the result.
*/

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n=encodedText.length();
        int cols=n/rows;
        char[][] matrix=new char[rows][cols];
        int k=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j]=encodedText.charAt(k);
                k++;
            }
        }
        StringBuilder st=new StringBuilder();
        for(int c=0;c<cols;c++){
            int col=c;
            int row=0;
            while(col<cols && row<rows){
                st.append(matrix[row][col]);
                col++;
                row++;
            }
        }
        while(st.length()>0 && st.charAt(st.length()-1)==' '){
            st.deleteCharAt(st.length()-1);
        }
        return st.toString();
    }
}