public class LinkedListDeque<T> {
    private class Node{
        public T item;
        public Node next;
        public Node prev;

        public Node(T i, Node n, Node p){
            item = i;
            next = n;
            prev = p;
        }

    }

    /** sentinel node and size */
    private Node sentinel;
    private int size;

    /** constructor: empty deque */
    public LinkedListDeque(){
        sentinel = new Node(null, null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
        //sentinel = new Node;
    }

    /** constructor: creates an deep copy of the given deque */
    /** @source J.H */
    public LinkedListDeque(LinkedListDeque other){
        sentinel = new Node(null, null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for(int i = 0; i<other.size(); ++i){
            addLast((T) other.get(i));
        }

    }

    /** add an item of type T to the front of deque */
    public void addFirst(T item){
        Node temp = sentinel.next;
        sentinel.next = new Node(item, sentinel.next, sentinel);
        temp.prev = sentinel.next;
        size = size + 1;
    }

    /** add an item to the end of deque */
    public void addLast(T item){
        Node temp = sentinel.prev;
        sentinel.prev = new Node(item, sentinel, sentinel.prev);
        temp.next = sentinel.prev;
        size = size + 1;

    }

    /** check if the it is empty, true if it is */
    public boolean isEmpty(){
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** return size */
    public int size(){
        return size;
    }
    /** print deque, separate each item with a space. Add a new line when done */
    public void printDeque() {
        if (isEmpty() == true) {
            System.out.println("The deque is empty");
            return;
        }
        Node temp = sentinel.next;
        while (temp != sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /** remove first */
    public T removeFirst(){
        if (isEmpty()==true){
            return null;
        }
        T data = sentinel.next.item;
        Node temp = sentinel.next.next;
        sentinel.next = temp;
        temp.prev = sentinel;
        size = size - 1;
        return data;

    }

    /** remove Last */
    public T removeLast(){
        if (isEmpty()==true){
            return null;
        }
        T data = sentinel.prev.item;
        Node temp = sentinel.prev.prev;
        temp.next = sentinel;
        sentinel.prev = temp;
        size = size - 1;
        return data;
    }

    /** get the item at given index, non-destructive */
    public T get(int index){
        if (isEmpty()==true || index>size+1){
            return null;
        }
        Node temp = sentinel.next;
        for(int i = 0; i < index; ++i, temp = temp.next);
        return temp.item;
    }

    public T getRecursive(int index){
        if (index == 0){
            return sentinel.next.item;
        }
        sentinel.next = sentinel.next.next;
        return getRecursive(index-1);
    }




    /** main function */
    public static void main(String[] args){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(2);
        L.addLast(5);
        L.addLast(7);
        L.addFirst(10);
        L.removeLast();
        System.out.println(L.getRecursive(0));
    }
}
