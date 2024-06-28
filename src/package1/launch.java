package package1;

import java.util.Random;
import java.util.Scanner;

class TicTacToe{
	static char[][] board;
	public TicTacToe()
	{
		board=new char[3][3];
		initboard();
	}
	void initboard()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j]=' ';
				
			}
		}
	}
	 static void dispboard()
	{
		System.out.println("-------------");
		for(int i=0;i<board.length;i++)
		{
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++)
			{
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	static void placemark(int row,int col,char mark)
	{
		if(row>=0 && row<=2 && col>=0 && col<=2)
		{
		board[row][col]=mark;
		}
		else
		{
			System.out.println("invalid input");
		}
	}
	static boolean pickwin()
	{
		for(int j=0;j<=2;j++)
		{
			if(board[0][j] !=' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
			{
				return true;
			}
			
		}
		return false;
	}
	static boolean coluwin()
	{
		for(int i=0;i<=2;i++)
		{
			if(board[i][0] !=' ' && board[i][0]==board[i][1] && board[i][1] ==board[i][2] )
			{
				return true;
			}
		}
		return false;
	}
	static boolean Daiwin()
	{
		if(board[0][0] !=' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] == board[1][1] && board[1][1] == board[2][1])
		{
			return true;
		}
		else {
			return false;
		}
	}
	static boolean Draw()
	{
		for(int i=0;i<=2;i++)
		{
			for(int j=0;j<=2;j++)
			{
				if(board[i][j]== ' ')
				{
					return false;
				}
			}
		}
		return true;
	}
	
}
abstract class player{
	String name;
	char mark;
	abstract void movemake();
	
		boolean isvalid(int row,int col) {
			if(row>=0 && row<=2 && col>=0 && col<=2)
			{
				if(TicTacToe.board[row][col] ==' ')
				{
					return true;
				}
			}
			return false;
		}
	}





class humanplayer extends player
{
	
	humanplayer(String name,char mark)
	{
		this.name =name;
		this.mark = mark;
	}
	void movemake()
	{
		Scanner scan=new Scanner(System.in);
		int row;
		int col;
		do{
		System.out.println("enter the row and col");
		 row =scan.nextInt();
		 col =scan.nextInt();
		
		}while(!isvalid(row,col));
		TicTacToe.placemark(row, col, mark);
	}
	
}

class AIplayer extends player
{
	
	AIplayer(String name,char mark)
	{
		this.name =name;
		this.mark = mark;
	}
	void movemake()
	{
		Scanner scan=new Scanner(System.in);
		int row;
		int col;
		do{
		Random r=new Random();
		row=r.nextInt(3);
		col=r.nextInt(3);
		
		}while(!isvalid(row,col));
		TicTacToe.placemark(row, col, mark);
	}
	
}
public class launch {
	public static void main(String[] args) {
		TicTacToe t=new TicTacToe();
		humanplayer p1=new humanplayer("arjun",'x');
		AIplayer p2=new AIplayer("TAI",'o');
		player cp;
		cp = p1;
		while(true) {
		System.out.println(cp.name + " turn");
		cp.movemake();
		TicTacToe.dispboard();
		if(TicTacToe.pickwin() || TicTacToe.coluwin() || TicTacToe.Daiwin())
		{
			System.out.println(cp.name + "has won");
			break;
		}
		else if(TicTacToe.Draw())
		{
			System.out.println("the game is draw");
			break;
		}
		else {
			if(cp == p1)
			{
				cp = p2;
			}
			else
			{
				cp = p1;
			}
		}
		}
		
	}

}
