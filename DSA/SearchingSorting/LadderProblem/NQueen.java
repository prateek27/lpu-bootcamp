package CompetitiveProgramming.SearchingSorting.LadderProblem;

import java.util.Arrays;

public class NQueen {
    public static boolean isSafe(char[][] board,int N,int i,int j){
        //check for col
        for(int row=0;row<=i;row++){
            if(board[row][j]=='Q'){
                return false;
            }
        }

        //check for diagonals
        int row = i,col=j;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row--;
            col--;
        }

        row = i;
        col=j;
        while(row>=0 && col<N){
            if(board[row][col]=='Q'){
                return false;
            }
            row--;
            col++;
        }
        return true;
    }
    public static int placeQueens(char[][] board,int N,int row){
        //base case
        if(row==N){
            for(int x=0;x<N;x++){
                for(int y=0;y<N;y++){
                    System.out.print(board[x][y] +" ");
                }
                System.out.println();
            }
            System.out.println("-------------------");
            return 1;
        }

        //rec case
        //place the queen at all possible columsn in the current row
        int currentAns = 0;

        for(int col=0;col<N;col++){
            if(isSafe(board,N,row,col)){
                board[row][col] = 'Q';
                currentAns += placeQueens(board,N,row+1);
                //backtracking
                board[row][col] = '.';
            }
        }
        return currentAns;
    }
    public static void main(String[] args) {
        int N = 4;
        char[][] board = new char[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(board[i],'.');
        }
        //counting ways
        int count = placeQueens(board,N,0);

        System.out.println(count);
    }
}
