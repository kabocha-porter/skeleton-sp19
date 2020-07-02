public class ArrayDeque<T> {
    private int size;
    private T[] array;
    private int nextLast;
    private int nextFirst;
    private int sizeFirst;

    /** constructor: empty list of arrays */
    public ArrayDeque(){
        size = 0;
        array = (T[]) new Object[3]; //should I initiate a different object length
        nextFirst = array.length - 1;
        nextLast = 0;
        sizeFirst = 0;
    }

    /** constructor: creates a deep copy of the given arraydeque */
    public ArrayDeque(ArrayDeque other){

    }

    /** resize function to adjust array size according to
     * the length of array correct resizing also needs be `inserted`
     * between the first item and the last item of the array */
    public void resize(int size) {
            T[] newArray = (T[]) new Object[size*2];
            System.arraycopy(array,0, newArray, 0, size-sizeFirst);
            System.arraycopy(array, size-sizeFirst, newArray, size*2-sizeFirst, sizeFirst);
            array = newArray;
    }

    /** wrapper function for position of the previous item */
    public int positionFirst(){
        if (size == 0){
            return 0;
        } else if (nextFirst == 0) {
            return nextFirst = array.length - 1; //First wrap to the end of array
        } else {
            return nextFirst = nextFirst - 1;
        }
    }

    /** wrapper function for position of the last item */

    /** add to the beginning of an array */
    public void addFirst(T item){
        if (size==array.length) {
            resize(size);
         };
        array[nextFirst] = item;
        size += 1;
        nextFirst = positionFirst();
        sizeFirst += 1;
    }

    public static void main(String[] args){
        ArrayDeque<Integer> L = new ArrayDeque();
        L.addFirst(5);
        L.addFirst(10);
        L.addFirst(15);
        L.addFirst(20);
    }

}

