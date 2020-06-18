public class PrintTriangle{
   public static void main(String[] args){
      int row = 1;
      int star = 0;
      while (row < 6){
         while (star < row){
            System.out.print("*");
            ++star;
         }
         System.out.print("\n");
         ++row;
         star = 0;
      }
   }
}
