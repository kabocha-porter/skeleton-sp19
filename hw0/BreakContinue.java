public class BreakContinue {
   public static void windowPosSum(int[] a, int n) {
      /** your code here */
      //advance each poition in the array
      for (int p=0; p<a.length; ++p){
         if (a[p]<0)
            continue;
         //calculate sum at position p
         for (int i=1; i<n+1; ++i){
            if (p+i>a.length-1)
               break;
            a[p]+=a[p+i];
         }
      }
   }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println();
    System.out.println(java.util.Arrays.toString(a));
  }
}
