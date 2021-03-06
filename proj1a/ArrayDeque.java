/** In this exercise, one needs to be clear about the differences between size/item.length and when to use which.
 * In fact, the absolute position of the element in the array is less important than the relative position of sequence of
 * elements. Once clear about it, printDeque and resize can be resolved in a simpler solution. The variable `sizeFirst`
 * is no longer needed because it denotes absolute position. Another thing to simply the code is to be clear about the
 * arithmetics of the array index and size.
 * @param <T>
 */
public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private T[] array;
    private int nextLast;
    private int nextFirst;

    /** constructor: empty list of arrays */
    public ArrayDeque(){
        size = 0;
        array = (T[]) new Object[8]; //should I initiate a different object length
        nextFirst = 7; //array.length - 1;
        nextLast = 0; //(nextFirst + size + 1)%array.length;
    }

    /** constructor: creates a deep copy of the given arraydeque
     * One caveat is that the absolute positioning of the element is different
     * But the structure of the arrays are private so does not affect functioning*/
    public ArrayDeque(ArrayDeque other){
        array = (T[]) new Object[8];
        nextFirst = 7;
        nextLast = 0;
        size = 0;
        for (int i = 0; i < other.size(); ++i)
        {
            addLast((T) other.get(i));
        }
    }


    /** return the size of the function */
    public int size(){
        return size;
    }

    /** resize function to adjust array size according to
     * the length of array correct resizing also needs be `inserted`
     * between the first item and the last item of the array */
    private void resize()
    {
        /** expand if array is full */

       /* if (size==array.length)
        {
            T[] newArray = (T[]) new Object[size * 2];
            System.arraycopy(array, 0, newArray, 0, size - sizeFirst);
            System.arraycopy(array, size - sizeFirst, newArray, size * 2 - sizeFirst, sizeFirst);
            array = newArray;
        }
        *//** shrink if size is less than 25% of length *//*
        else if (size < .25 * array.length && array.length > 16 )
        {
            T[] newArray = (T[]) new Object[array.length / 2];
            System.arraycopy(array, 0, newArray, 0, size - sizeFirst);
            System.arraycopy(array, size - sizeFirst, newArray, array.length / 2 - sizeFirst, sizeFirst);
            array = newArray;
        }*/
        /** the assignment operator here is probably not the best solution, could us arraycopy instead */
        if (size==array.length)
         {
             T[] newArray = (T[]) new Object[size * 2];
           for (int i = 0; i < size; ++i)
               {
                   newArray[i] = get(i);
               }
           array = newArray;
           nextFirst = array.length - 1;
           nextLast = size;
         } else if (size < .25 * array.length && array.length > 16)
         {
            T[] newArray = (T[]) new Object[array.length / 2];
            for (int i = 0; i < size; ++i)
            {
                newArray[i] = get(i);
            }
            array = newArray;
            nextFirst = array.length - 1;
            nextLast = size;
         }
    }


    /** helper function for position of the previous item
     */
    private int decrement(int index)
    {
        return (index + array.length - 1) % array.length;
    }
    /**
        if (size == 0){
            return 0;
        } else if (index == 0) {
            return index = array.length - 1; //First wrap to the end of array
        } else {
            return index = index - 1;
        }
    }
     */

    /** add to the beginning of an array */
    @Override
    public void addFirst(T item){
        resize();
        array[nextFirst] = item;
        size += 1;
        nextFirst = decrement(nextFirst);
    }

    /** helper function for position of the last item */
    private int increment(int index){
        return (index + 1) % array.length;
        /**
        if (size == 0){
            return 0;
        } else if (index == array.length - 1){
            return index = 0;
        } else {
            return index += 1;
        }
         */
    }

    /** add to the last of an array */
    @Override
    public void addLast(T item){
        resize();
        array[nextLast] = item;
        size += 1;
        nextLast = increment(nextLast);
    }

    /** get an item at the given index */
    @Override
    public T get(int index) {

        return array[(index+nextFirst+1)%array.length];
    }

    /** remove and return the first item in the array deque */
    @Override
    public T removeFirst() {
        if(isEmpty())
                return null;
        resize();
        nextFirst = increment(nextFirst);
        T copy = array[nextFirst];
        array[nextFirst] = null;
        size -= 1;
        return copy;
    }

    /** remove the last item in the array deque */
    @Override
    public T removeLast()
    {
        if (isEmpty())
            return null;
        resize();
        nextLast = decrement(nextLast);
        T copy = array[nextLast];
        array[nextLast] = null;
        size -=1;
        return copy;
    }

    /** print array deque
    public void printDeque() {

        for (int i = increment(nextFirst); i < increment(nextFirst) + sizeFirst; ++i) {
            System.out.print(array[i] + " ");
        }
        for (int i = 0; i < size - sizeFirst; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
     public void printDeque{
     for (T p : array)
     {
     System.out.print(p + " ");
     }
     }
     */

    /** eliminate sizeFirst and print out according to relative position */
    @Override
    public void printDeque() {
        int j = increment(nextFirst);
        for (int i = 0; i < size; ++i)
        {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        ArrayDeque<Integer> L = new ArrayDeque();

        for (int i = 0; i < 30; ++i)
        {
            L.addLast(i);
        }
        L.addFirst(10);
        L.addFirst(10);
        L.addFirst(10);
        L.addLast(30);
        L.addLast(30);
        L.printDeque();
        for (int i = 0; i < 3; ++i)
        {
            L.removeFirst();
        }
        L.printDeque();
        L.addFirst(10);
        L.addFirst(10);
        L.addFirst(10);
        for (int i  = 0; i < 23; ++i)
        {
            L.removeLast();
        }
        L.printDeque();
        for (int i = 0; i < 10; ++i)
        {
            L.addLast(i);
        }
        L.printDeque();
        for (int i = 0; i < 20; ++i)
        {
            L.removeFirst();
        }
        L.printDeque();
        System.out.println(L.get(0));
    }

}

