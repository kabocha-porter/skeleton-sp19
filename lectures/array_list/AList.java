/** Array based list.
 *  @author Josh Hug
 */

public class AList<T> {
    private T[] array;
    private int size;
    /** Creates an empty list. */
    public AList() {
       array = (T[]) new Object[100];
       size = 0;
    }

    /** Add to the end of the list requires creating 
      * a new array of size = size +1 and copy the content */
    public void resize(int capacity){
       T[] a = (T[]) new Object[size* 2];
       System.arraycopy(array, 0, a, 0, size);
       array = a;
    }
    /** Inserts X into the back of the list. */
    public void addLast(T x) {
       if (array.length >= size){
          resize(size + 1);
       }
       array[size] = x;
       size += 1;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        T x = array[size-1];
        return x;        
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return array[i];        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public T removeLast() {
        T x = array[size - 1];
        array[size -1] = null;
        size = size -1;

        return x;
    }

    public static void main(String[] args){
       AList x = new AList();
       x.addLast(5);
    }





} 

