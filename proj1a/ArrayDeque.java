public class ArrayDeque<T> {
    private int size;
    private T[] array;
    private int nextLast;
    private int nextFirst;
    private int sizeFirst;

    /** constructor: empty list of arrays */
    public ArrayDeque(){
        size = 0;
        array = (T[]) new Object[4]; //should I initiate a different object length
        nextFirst = array.length - 1;
        nextLast = (nextFirst + size + 1)%array.length;
        sizeFirst = array.length - (nextFirst  + 1);
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

    /** return true if the array is empty */
    public boolean isEmpty(){
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }

    /** return the size of the function */
    public int size(){
        return size;
    }

    /** resize function to adjust array size according to
     * the length of array correct resizing also needs be `inserted`
     * between the first item and the last item of the array */
    public void resize() {
        /** expand if array is full */
        if (size==array.length)
        {
            T[] newArray = (T[]) new Object[size * 2];
            System.arraycopy(array, 0, newArray, 0, size - sizeFirst);
            System.arraycopy(array, size - sizeFirst, newArray, size * 2 - sizeFirst, sizeFirst);
            array = newArray;
        }
        /** shrink if size is less than 25% of length */
        else if (size < .25 * array.length && array.length > 16 )
        {
            T[] newArray = (T[]) new Object[array.length / 2];
            System.arraycopy(array, 0, newArray, 0, size - sizeFirst);
            System.arraycopy(array, size - sizeFirst, newArray, array.length / 2 - sizeFirst, sizeFirst);
            array = newArray;
        }
        /** if (size==array.length || size < .25 * array.length)
         *{
         *  T[] newArray = (T[]) new Object[size * 2];
         *  for (int i = 0; i < size; ++i)
         *      {
         *          newArray[i] = addLast((T) get(i));
         *      }
         * }
         *      array = newArray;
         *      nextFirst = array.length - 1;
         *      nextLast = size;
         */
    }


    /** wrapper function for position of the previous item
     */
    public int decrement(int index){
        if (size == 0){
            return 0;
        } else if (index == 0) {
            return index = array.length - 1; //First wrap to the end of array
        } else {
            return index = index - 1;
        }
    }

    /** add to the beginning of an array */
    public void addFirst(T item){
        resize();
        array[nextFirst] = item;
        size += 1;
        nextFirst = decrement(nextFirst);
        sizeFirst += 1;
    }

    /** wrapper function for position of the last item */
    public int increment(int index){
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
    public void addLast(T item){
        resize();
        array[nextLast] = item;
        size += 1;
        nextLast = increment(nextLast);
    }

    /** get an item at the given index */
    public T get(int index) {
        if (index > size - 1)
            return null;
        return array[(index+nextFirst+1)%array.length];
    }

    /** remove and return the first item in the array deque */
    public T removeFirst() {
        T copy = get(0);
        nextFirst = increment(nextFirst);
        array[nextFirst] = null;
        size -= 1;
        sizeFirst -= 1;
        return copy;
    }

    /** remove the last item in the array deque */
    public T removeLast(){
        T copy = get(size-1);
        nextLast = decrement(nextLast);
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
     */

    /** eliminate sizeFirst and print out according to relative position */
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
        L.addFirst(5);
        L.addFirst(10);
        L.addFirst(15);
        L.addFirst(20);
        L.addLast(27);
        L.addLast(17);
        L.addLast(7);
        L.removeFirst();
        L.removeLast();
        L.printDeque();
        System.out.println(L.get(2));
        ArrayDeque<Integer> M = new ArrayDeque(L);
        M.printDeque();
    }

}

