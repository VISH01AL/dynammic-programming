import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	 public static void main (String[] args) throws IOException
	 {
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 StringBuffer sb=new StringBuffer();
	 int T=Integer.parseInt(br.readLine());
	 while(T-->0)
	 {
	     String s=br.readLine();
	     char[] c=s.toCharArray();
	     int len=s.length();
	     boolean[][] b=new boolean[len][len];
	     fillbool(c,b,0,len-1);
	     int[][] dp=new int[len][len];
	     for(int[] x:dp)
	         Arrays.fill(x,-1);
	     int ans=numberofsplits(c,b,0,len-1,dp);
	     sb.append(ans+"\n");
	 }
	 System.out.print(sb);
	 }
     public static boolean fillbool(char[] c,boolean[][] b,int i,int j)
	 {
	     if(i==j)
	     {
	         return b[i][j]=true;
	     }
	     if(i>j)
	     {
	         return true;
	     }
	     if(c[i]==c[j])
	     {
	         b[i][j]=fillbool(c,b,i+1,j-1);
	     }
	     fillbool(c,b,i+1,j);
	     fillbool(c,b,i,j-1);
	     return b[i][j];
	 }
	 public static int numberofsplits(char[] c,boolean[][] b,int i,int j,int[][] dp)
	 {
	     if(i>j)
	     {
	         return 0;
	     }
	     if(b[i][j])
	     {
	         return dp[i][j]=0;
	     }
	     if(dp[i][j]!=-1)
	     {
	         return dp[i][j];
	     }
	     int ret=j;
	     for(int k=i;k<j;k++)
	     {
	       ret=Math.min(ret,1+numberofsplits(c,b,i,k,dp)+numberofsplits(c,b,k+1,j,dp));
	     }
	     return dp[i][j]=ret;
	 }
}