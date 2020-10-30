package array;

/**
 * @author: suruomo
 * @date: 2020/10/30 11:27
 * @description: 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地0 表示水域。
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。
 * 整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。
 * 计算这个岛屿的周长。
 */
public class IsLandPerimeter {
   public int isLandPerimeter(int[][] grid){
       int[] dx={0,1,0,-1};
       int[] dy={1,0,-1,0};
       int rows= grid.length;
       int columns=grid[0].length;
       int ans=0;
       for (int i = 0; i < rows; i++) {
           for (int j = 0; j < columns; j++) {
               int cnt=0;
               for (int m=0;m<4;m++){
                   if (grid[i][j]==1){
                       int x=i+dx[m];
                       int y=j+dy[m];
                       if (x<0||x>=rows||y<0||y>=columns||grid[x][y]==0){
                           cnt+=1;
                       }
                   }
               }
               ans+=cnt;
           }
       }
       return ans;
   }
}
