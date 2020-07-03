public class ArrayDeque<T> {
    private int size;
    private T[] array;
    private int nextLast;
    private int nextFirst;
    private int sizeFirst;
    private int sizeLast;

    /** constructor: empty list of arrays */
    public ArrayDeque(){
        size = 0;
        array = (T[]) new Object[8]; //should I initiate a different object length
        nextFirst = array.length - 1;
        nextLast = 0;
        sizeFirst = 0;
    }

    /** constructor: creates a deep copy of the given arraydeque */
    public ArrayDeque(ArrayDeque other){

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
    public void resize(int size) {
            T[] newArray = (T[]) new Object[size*2];
            System.arraycopy(array,0, newArray, 0, sizeLast);
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

    /** wrapper function for position of the last item */
    public int positionLast(){
        if (size == 0){
            return 0;
        } else if (nextLast == array.length - 1){
            return nextLast = 0;
        } else {
            return nextLast += 1;
        }
    }

    /** add to the last of an array */
    public void addLast(T item){
        if (size==array.length) {
            resize(size);
        };
        array[nextLast] = item;
        size += 1;
        nextFirst = positionLast();
        sizeLast += 1;
    }

    /** remove the first item in the array deque */
    public T removeFirst(){

    }

    /** remove the last item in the array deque */
    public T removeLast(){

    }

    /** print array deque */
    public void printDeque() {
        for (int i = 0; i < sizeLast; ++i) {
            System.out.print(array[i] + " ");
        }
        for (int i = array.length - sizeFirst; i < array.length; ++i) {
            System.out.print(array[i] + " ");
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
        L.printDeque();
    }

}

