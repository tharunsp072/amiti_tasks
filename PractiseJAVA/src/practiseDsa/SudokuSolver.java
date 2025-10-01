package practiseDsa;

public class SudokuSolver {
	public static void main(String args[]) {
		char[][] board = new char[15][15];
		helper(board,0,0);
	}
	
	public static boolean helper(char[][] board,int row,int col) {
		if(row == board.length) {
			return true;
		}
		
		int nrow = 0,ncol=0;
		
		if(col == board.length-1) {
			nrow = row+1;
			ncol = 0;
		} else {
			ncol = col +1;
			nrow = row;	
		}
		
		if(board[row][col] != '.') {
			if(helper(board,nrow,ncol)) {
				return true;
			}
		} else {
			for(int i=1;i<=9;i++) {
				if(isSafe(board,row,col,i)) {
					board[row][col] = (char)('0' + i);
					if(helper(board,row,col)) {
						return true;
					} else {
						board[row][col] = '.';
					}
				}
			}
		}
		return false;
	}
	
	
	public static boolean isSafe(char[][] board,int row,int col,int number) {
		for(int i=0;i<board.length-1;i++) {
			if(board[i][col] == (char)(number + '0')) {
				return false;
			}
			if(board[row][i] == (char)(number + '0')) {
				return false;
			}
		}
		
		int sr = (row /3) *3;
		int sc = (col/3) * 3;
		for(int i=sr;i<sr+3;i++) {
			for(int j=sc;j<sc+3;j++) {
				if(board[i][j]==(char)(number + '0')) {
					return false;
				}
			}
		}
		return true;
	}
}	
