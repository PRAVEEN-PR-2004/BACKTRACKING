
import java.util.*;
public class Maze3
{
    public static int minpath = 100000;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] ans = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] sol = new int[n][n];
    
       path(0,0,n,arr,sol,ans,1);
       
       if(minpath!=100000)
       {
           System.out.println("Minimum Steps: "+minpath);
           for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                   System.out.print(ans[i][j]+" ");
               }
               System.out.println();
           }
       }
    }
    public static boolean path(int x,int y,int n,int[][] arr,int[][] sol,int[][] ans,int count)
    {
        if(x==n-1 && y==n-1 && sol[x][y]==0)
        {
          sol[x][y]=1;
          if(count<minpath)
          {
              minpath=count;
              for(int i=0;i<n;i++)
              {
                  for(int j=0;j<n;j++)
                  {
                      ans[i][j] =sol[i][j];
                  }
              }
          }
          sol[x][y]=0;
          return false;
          
        }
        if(x<n && y<n && x>=0 && y>=0 && arr[x][y]==0 && sol[x][y]==0)
        {
            sol[x][y]=1;
            if(path(x+1,y,n,arr,sol,ans,count+1))
            {
                return true;
            }
            if(path(x-1,y,n,arr,sol,ans,count+1))
            {
                return true;
            }
            if(path(x,y+1,n,arr,sol,ans,count+1))
            {
                return true;
            }
            if(path(x,y-1,n,arr,sol,ans,count+1))
            {
                return true;
            }
            sol[x][y]=0;
            return false;
            
        }
        return false;
        
    }
    
    
    
    
}