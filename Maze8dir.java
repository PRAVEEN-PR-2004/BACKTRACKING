
import java.util.*;
public class Maze8dir {
    public static int minpath = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int[][] sol = new int[n][2];
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < 2; j++) 
            {
                arr[i][j] = sc.nextInt();
            }
        }
        int st = arr[0][0]-1;
        path(0,0,arr,sol,st,0,n);
        if(minpath==Integer.MAX_VALUE)
        {
            System.out.print(-1);
        }
        else
        {
            System.out.print(minpath);
        }
        
        
    }
    public static boolean path(int x,int y,int[][] arr,int[][] sol,int st,int c,int n)
    {
        if(x==n-1 && y==1 && sol[x][y]==0)
        {
            sol[x][y]=1;
            if(c<minpath)
            {
                minpath = c;
            }
            sol[x][y]=0;
            return false;
        }
        if(x>=0 && y>=0 && x<n && y<2 && sol[x][y]==0 && arr[x][y]==st+1)
        {
            sol[x][y]=1;
            if(path(x+1,y,arr,sol,arr[x][y],c+1,n)) return true;
            if(path(x,y+1,arr,sol,arr[x][y],c+1,n))return true;
            if(path(x-1,y,arr,sol,arr[x][y],c+1,n)) return true;
            if(path(x,y-1,arr,sol,arr[x][y],c+1,n)) return true;
            if(path(x+1,y+1,arr,sol,arr[x][y],c+1,n))return true;
            if(path(x-1,y-1,arr,sol,arr[x][y],c+1,n))return true;
            if(path(x-1,y+1,arr,sol,arr[x][y],c+1,n))return true;
            if(path(x+1,y-1,arr,sol,arr[x][y],c+1,n))return true;
            sol[x][y]=0;
            return false;
        }
        return false;
    }
}

  