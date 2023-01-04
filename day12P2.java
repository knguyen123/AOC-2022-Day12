import java.util.*;
import java.io.*;
public class day12P2{
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
      ArrayList<Integer> n = new ArrayList<>();
      for(int r = 0; r < 41; r++){
        	for(int c = 0; c < 64; c++){ 
            if(m.get(r).get(c).getV()=='a')
               find(m, r, c, n);
            
            for(int row = 0; row < 41; row++){
              	for(int col = 0; col < 64; col++){        
                  m.get(row).get(col).setN(0);
               }
            }
         }
      }
      int low = 999;
      for(int i = 0; i < n.size(); i++){
         if(n.get(i)<low){
            low = n.get(i);
         }
      }
      System.out.print(low+"");
   }

   public static void find(ArrayList<ArrayList<Coord>> m, int row, int col, ArrayList<Integer> n){
      LinkedList<Coord> ll = new LinkedList<>();
      ll.add(m.get(row).get(col));
      while(ll.size()>0){
         int r = ll.getFirst().getR();
         int c = ll.getFirst().getC();
         char v = ll.removeFirst().getV();
         
         if(r-1>=0){
            if((int)v+1>=(int)m.get(r-1).get(c).getV()&&m.get(r-1).get(c).getN()==0){
               m.get(r-1).get(c).setN(m.get(r).get(c).getN()+1);
               if(m.get(r-1).get(c).getV()=='{')
                  n.add(m.get(r-1).get(c).getN());
               ll.addLast(m.get(r-1).get(c));
            }
         }
         if(r+1<41){
            if((int)v+1>=(int)m.get(r+1).get(c).getV()&&m.get(r+1).get(c).getN()==0){
               m.get(r+1).get(c).setN(m.get(r).get(c).getN()+1);
               if(m.get(r+1).get(c).getV()=='{')
                  n.add(m.get(r+1).get(c).getN());
               ll.addLast(m.get(r+1).get(c));
            }
         }
         if(c-1>=0){
            if((int)v+1>=(int)m.get(r).get(c-1).getV()&&m.get(r).get(c-1).getN()==0){
               m.get(r).get(c-1).setN(m.get(r).get(c).getN()+1);
                if(m.get(r).get(c-1).getV()=='{')
                  n.add(m.get(r).get(c-1).getN());
               ll.addLast(m.get(r).get(c-1));
            }
         }
         if(c+1<63){
            if((int)v+1>=(int)m.get(r).get(c+1).getV()&&m.get(r).get(c+1).getN()==0){
               m.get(r).get(c+1).setN(m.get(r).get(c).getN()+1);
                if(m.get(r).get(c+1).getV()=='{')
                  n.add(m.get(r).get(c+1).getN());
               ll.addLast(m.get(r).get(c+1));
            }
         }
      }
   }
}