public class MaxNumber {
   public static int max(int[] m) {
      int len = m.length;
      int temp=0;
      for (int i = 0; i<len; ++i){
         if (m[i]>temp)
            temp = m[i];
      }
      return temp;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
      System.out.println(max(numbers));
   }
}
