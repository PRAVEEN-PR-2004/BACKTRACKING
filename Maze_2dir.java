import java.util.*;

    public class Maze_2dir
    {
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[][] qus = new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    qus[i][j] = sc.nextInt();
                }
            }
            int[][] sol = new int[n][n];
            if(path(0,0,sol,n,qus) == true)
            {
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        System.out.print(sol[i][j] + " ");                    
                    }
                    System.out.println();
                }
            }
            else
            {
                System.out.print("No solution exists");
            }
            sc.close();;
        }
        public static boolean path(int x,int y,int[][] sol,int n,int[][] qus)
        {
            if((x==n-1)&&(y==n-1))
            {
                sol[x][y] = 1;
                return true;
            }
            if(x<n && y<n && qus[x][y] == 0)
            {
                sol[x][y] = 1;
                if(path(x+1,y,sol,n,qus) == true)
                {
                    return true;
                }
                if(path(x,y+1,sol,n,qus)== true)
                {
                    return true;
                }
                sol[x][y] = 0;
                return false;
                
            }
            return false;
       }
   }
