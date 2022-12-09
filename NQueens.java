import java.lang.*;
import java.util.*;

public class NQueens
{
    static int[][] board;
    static int numberOfQueens;
    static int queensPlaced=0;
	public static void main(String[] args)
	{
		Scanner sn = new Scanner(System.in);

		System.out.print("Enter no. of queens : ");
		numberOfQueens = sn.nextInt();
		board = new int[numberOfQueens][numberOfQueens];

		if(numberOfQueens <= 3)
		    System.out.println("No Solution");
		else
		{
    		for(int z=0; z < numberOfQueens; z++)
    		    Arrays.fill(board[z], 0);

    		int result = Queen(0);

    	    for(int p=0; p<numberOfQueens; p++)
    		{
    			for(int q=0; q < numberOfQueens; q++)
    				System.out.print(board[p][q] + " ");
    		    System.out.println();
    		}
		}
	}

	public static int Queen(int row)
	{
	    for(int i=0; i<numberOfQueens; i++)
	    {
	       if(check(row, i)==1)
           {
               board[row][i] = 1;   //if condition satisfies then marking it as 1

               queensPlaced++;      // incrementing number of queens placed

               if(queensPlaced == numberOfQueens)
                    return 1;

               int result = Queen(row+1);

               if(result == 0)
               {
                   board[row][i] = 0;   // backtracking
                   queensPlaced--;
               }
               else
                    return 1;
           }
	    }
	    return 0;
	}

	public static int check(int row, int column)
	{
		for(int z=0; z<numberOfQueens; z++)
        {
        	if(board[row][z] == 1)    //checking row
        		return 0;
        }
        for(int z=0; z<numberOfQueens; z++)
        {
        	if(board[z][column] == 1)   // checking column
        		return 0;
        }
	    for(int i=0; i<numberOfQueens; i++)
	    {
	        for(int j=0; j<numberOfQueens; j++)
	        {
	            if(((i+j) == (row+column) || (i-j) == (row-column)) && board[i][j] == 1) // checking daigonals
	                return 0;
	        }
	    }
	    return 1;
	}
}