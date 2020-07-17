public interface Deque<Item> {
    public void addFirst(Item x);
    public void addLast(Item x);
    public int size();
    public void printDeque();
    public Item removeFirst();
    public Item removeLast();
    public Item get(int index);
    /**
     * a default constructor for implementation inheritance;
     */
    default public boolean isEmpty()
    {
        if (0==size())
            return true;
        else
            return false;
    }

}
