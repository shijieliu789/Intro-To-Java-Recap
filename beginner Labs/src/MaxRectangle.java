import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {

        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println("max area is: " + maximalRectangle(matrix));
    }

    //approach - turn to histogram:
    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;    //finds row and col of matrix
        int col = row == 0 ? 0 : matrix[0].length;
        int[][] height = new int[row][col];

        //form the new height array to recorded a rectangle's height of '1's,
        //For each row, if matrix[row][i] == '1'. height[row][i] += 1, or reset the height[row][i] to zero.
        for (int i=0; i<row; i++){
            for (int j=0; j< col; j++){                         //replaces height cell with the cell above increment
                if (matrix[i][j] == '1'){ height[i][j] = i == 0 ? 1 : height[i-1][j]+1;}
                else {
                    height[i][j] = 0;
                }
                System.out.print(height[i][j]);
            }
            System.out.println("");
        }

        //calculate max rectangle row by row:
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            maxArea = Math.max(maxArea, maxAreaInHist(height[i]));
        }

        return maxArea;
    }

    private static int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int cur = i == height.length ? -1 : height[i];  // set cur = value stored at the height row array, -1 to indicate stopping point

            while (!stack.isEmpty() && cur< height[stack.peek()])  //if stack is NOT empty and current value is smaller than the top of the stack meaning we have encountered a complete rectangle at this point
            {
                int h = height[stack.pop()]; //retrieve last value
                int w = stack.isEmpty()? i : (i - stack.peek() - 1);
                max = Math.max(max, w*h);
                System.out.println("in loop:  max is = " + max);
            }
            System.out.println("pushing " + i + "to stack");
            stack.push(i);
            System.out.println(cur);
        }
        System.out.println("new line");
        return max;
    }
}
