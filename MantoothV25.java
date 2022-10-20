import java.util.*;
public class MantoothV25
{
   public static void main(String [] args)
   {
    PetriDish p = new PetriDish();
        p.showGrid();
        /*Change the (4,4) to be a random valid value within the grid*/
        int l = p.length();
        int w = p.width();
        int rand1 = (int)(Math.random()*(l+1));
        int rand2 = (int)(Math.random()*(w+1));
        System.out.println(p.numNeighbors(rand1,rand2));
        p.updateGrid();
        p.showGrid();
        
    }
     
}
class PetriDish
{
    private boolean[][] grid;
    public PetriDish()
    {
        int rand1 = (int)(Math.random()*26+5);
        int rand2 = (int)(Math.random()*26+5);
        grid = new boolean [rand1][rand2];
        for(int r = 0; r<grid.length; r++)
        {
            for(int c = 0; c<grid[0].length; c++)
            {
                int rand3 = (int)(Math.random()*10+1);
                if(rand3<=3)
                {
                    grid[r][c] = true;
                }
                else
                {
                    grid[r][c] = false;
                }
            }
        }
    }
    //Complete the showGrid method which displays the current state of the grid.
        public void showGrid()
    {
        for(int r = 0; r<grid.length; r++)
        {
            for(int c = 0; c<grid[0].length; c++)
            {
                if(grid[r][c])
                {
                    System.out.print(" O ");
                }
                else
                {
                    System.out.print(" . ");
                }
            }
            System.out.print("\n");
        }
    }
     /*Complete the method numNeighbors which returns the number of adjacent true elements in the grid
      *Postcondition: the return value is a value from 0 to 8, inclusive*/
    public int numNeighbors(int row, int col)
        {
        int count = 0;
        for(int r = -1; r<2; r++)
        {
            for(int c = -1; c<2; c++)
            {
                if(row+r>0&& row+r<grid.length&& col+c>0&& col+c<grid[0].length)
                {
                   if(grid[row+r][col+c])
                   {
                       count ++;
                   }
                }
            }
        }
        if(grid[row][col])
        {
            count --;
        }
        return count;
    }
    public int length()
    {
        return grid.length;
    }
    public int width()
    {
        return grid[0].length;
    }
    public boolean updateCell(int r, int c)
    {
      int count = numNeighbors(r,c);
      if(grid[r][c])
         {if(count==2 || count==3)
            {return true;}}
      return false;
    }
    public void updateGrid()
    {
      boolean [][]temp = new boolean [grid.length][grid[0].length];
      for(int r = 0; r< grid.length; r++)
         {for(int c = 0; c<grid[0].length; c++)
            {
               temp[r][c] = updateCell(r,c);
            }}
      for(int r = 0; r<grid.length; r++)
         for(int c = 0; c<grid[0].length; c++)
            grid[r][c] = temp[r][c];
    }

}