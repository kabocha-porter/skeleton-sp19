public class ArrayDeque<T> {
    private int size;
    private T[] item;
    private T nextLast;
    private T nextFirst;

    /** constructor: empty list of arrays */
    public ArrayDeque(){
        size = 0;
        item = (T[]) new Object[10];
        nextFirst = item[0];
        nextLast = item[item.length-1];
    }

    /** constructor: creates a deep copy of the given arraydeque */
    public ArrayDeque(ArrayDeque other){

    }


}

