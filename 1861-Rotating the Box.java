class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        for (int r = 0; r < rows; r++) {
            int empty = cols - 1;
            for (int c = cols - 1; c >= 0; c--) {
                if (box[r][c] == '*') {
                    empty = c - 1;
                }
                else if (box[r][c] == '#') {
                    char temp = box[r][c];
                    box[r][c] = box[r][empty];
                    box[r][empty] = temp;

                    empty--;
                }
            }
        }
        char[][] ans = new char[cols][rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ans[c][rows - 1 - r] = box[r][c];
            }
        }
        return ans;
    }
}