import java.util.*;
import java.io.*;
public class day12{
    public static void main(String[] args) throws FileNotFoundException{
      ArrayList<ArrayList<Coord>> m = new ArrayList<>();
      Scanner f = new Scanner(new File("mountain.txt"));
      for(int r = 0; r < 41; r++){
         String s = f.nextLine();
         ArrayList<Coord> arr = new ArrayList<>();
        	for(int c = 0; c < 64; c++){        
            Coord co = new Coord(s.charAt(c));		
            arr.add(co);
         }
         m.add(arr);
      }
      
      for(int r = 0; r < 41; r++){
        	for(int c = 0; c < 64; c++){        
            m.get(r).get(c).setRC(r,c);
         }
      }
      LinkedList<Coord> ll = new LinkedList<>();
      ll.add(m.get(20).get(0));
      while(ll.size()>0){
         int r = ll.getFirst().getR();
         int c = ll.getFirst().getC();
         char v = ll.removeFirst().getV();
         
         if(r-1>=0){
            if((int)v+1>=(int)m.get(r-1).get(c).getV()&&m.get(r-1).get(c).getN()==0){
               m.get(r-1).get(c).setN(m.get(r).get(c).getN()+1);
               if(m.get(r-1).get(c).getV()=='{')
                  System.out.print(m.get(r-1).get(c).getN()+"");
               ll.addLast(m.get(r-1).get(c));
            }
         }
         if(r+1<41){
            if((int)v+1>=(int)m.get(r+1).get(c).getV()&&m.get(r+1).get(c).getN()==0){
               m.get(r+1).get(c).setN(m.get(r).get(c).getN()+1);
               if(m.get(r+1).get(c).getV()=='{')
                  System.out.print(m.get(r+1).get(c).getN()+"");
               ll.addLast(m.get(r+1).get(c));
            }
         }
         if(c-1>=0){
            if((int)v+1>=(int)m.get(r).get(c-1).getV()&&m.get(r).get(c-1).getN()==0){
               m.get(r).get(c-1).setN(m.get(r).get(c).getN()+1);
                if(m.get(r).get(c-1).getV()=='{')
                  System.out.print(m.get(r).get(c-1).getN()+"");
               ll.addLast(m.get(r).get(c-1));
            }
         }
         if(c+1<63){
            if((int)v+1>=(int)m.get(r).get(c+1).getV()&&m.get(r).get(c+1).getN()==0){
               m.get(r).get(c+1).setN(m.get(r).get(c).getN()+1);
                if(m.get(r).get(c+1).getV()=='{')
                  System.out.print(m.get(r).get(c+1).getN()+"");
               ll.addLast(m.get(r).get(c+1));
            }
         }
      }
      /*
      LinkedList<Integer> rs = new LinkedList<>();
      LinkedList<Integer> cs = new LinkedList<>();
      rs.add(0);
      cs.add(0);
      while(rs.size()>0||cs.size()>0){
         int r = -9;
         int c = -9;
         if(rs.size()>0)
            r = rs.removeFirst();
         if(cs.size()>0)
            c = cs.removeFirst();
         
         int n1 = 0;
         int n2 = 0;
         if(r+1<5){
            rs.addLast(r+1);
            n1++;
         }
         if(r-1>=0){
            rs.addLast(r-1);
            n1++;
         }
         if(c+1<8){
            cs.addLast(c+1);
            n2++;
         }
         if(c-1>=0){
            cs.addLast(c-1); 
            n2++;
         }
         for(int i = 0; i < n1; i++){
            int num = m(m,n,rs.get(i),c,r,c);
            if(num==2){
               break;
            }
            if(num==1){
               rs.removeFirst();
               i--;
               n1--;
            }
         }
         for(int i = 0; i < n2; i++){
            int num = m(m,n,r,cs.get(i),r,c);
            if(num==2){
               break;
            }
            if(num==1){
               cs.removeFirst();
               i--;
               n2--;
            }
         }
      }
      */
   }
   /*
    public static int m(char[][] m, int[][] n,int r, int c, int pr, int pc){      
      if((int)m[r][c]>(int)m[pr][pc]+1||n[r][c]>0){
         return 1;
      }  
      n[r][c] = n[pr][pc]+1;  
      
      if(m[r][c]=='{'){
         System.out.println(n[r][c]+"");
         return 3;
      }
      //if(m(m,r+1, c,m[r][c],n)||m(m,r-1, c,m[r][c],n)||m(m,r, c+1,m[r][c],n)||m(m,r, c-1,m[r][c],n)){
      //   System.out.println((n-1)+"");
      //   return true;
      //}
      
      
      return 2;     
    }
    */
} 


class Coord{
   private int r;
   private int c;
   private char v;
   private int n = 0;
   
   public Coord(char V){
      //r = R;
      //c = C;
      v = V;
   }
   
   public int getR(){
      return r;
   }
   
   public int getC(){
      return c;
   }
   
   public char getV(){
      return v;
   }
   
   public int getN(){
      return n;
   }
   
   public void setRC(int R, int C){
      r = R;
      c = C;
   }
   
   public void setN(int N){
      n = N;
   }
   
   public int compareTo(Coord other){
      return this.v-other.v;
   }
}

