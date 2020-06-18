public class NTriangle {
   public static void drawTriangle(int N){
      int row = 1;
      int star = 0;
      while (row < N+1){
         while (star < row){
            System.out.print("*");
            ++star;
         }
         System.out.print("\n");
         ++row;
         star = 0;
      }
   }

   public static void main(String[] args) {
      drawTriangle(10); 
   }
}


