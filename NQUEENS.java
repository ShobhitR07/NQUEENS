public class NQueens {
	
	
	private boolean[][] board ;
	
	public NQueens(int n) {
		board=new boolean[n][n] ;
		System.out.println(place(board,0)) ;
	}
	
	
	
	private static void display(boolean[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j])System.out.print("Q ") ;
				else System.out.print("X ");
			}
			System.out.println();
		}
	}
	
	
	
	private static boolean issafe(boolean[][] board,int r,int c) {
		//check in same column 
		for(int i=r-1;i>=0;i--) {
			if(board[i][c])return false ;
		}
		//check in right diagonal
		int i=r-1,j=c+1 ;
		while(i>=0&&j<board.length) {
			if(board[i][j])return false ;
			i--;
			j++ ;
		}
		//check in left diagonal
		i=r-1 ;
		j=c-1 ;
		while(i>=0&&j>=0) {
			if(board[i][j])return false ;
			i-- ;
			j-- ;
		}
		
		//if you reach here then queen can be placed at r,c
		return true ;
	}
	
	
	
	private static int place(boolean[][] board,int r) {
		
		if(r==board.length) {
			display(board) ;
			System.out.println();
			return 1 ;
		}
		int count=0 ;
		
		for(int j=0;j<board.length;j++) {
			
			if(issafe(board,r,j)) {
				board[r][j]=true ;
				count+=place(board,r+1) ;
				board[r][j]=false ;
			}
			
			
		}
		
		
		return count ;
	}
	
	
}
