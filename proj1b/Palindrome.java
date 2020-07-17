public class Palindrome {
    /**
     * there is no constructor or anything about the members in this class
     * @param word
     * @return
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> x = new ArrayDeque<>(); //or new LinkedListDeque<>()
        for(int i = 0; i < word.length(); ++i){
            x.addLast(word.charAt(i));
        }
        return x;
    }

    private boolean isPalindrome(Deque t) {
        if (t.isEmpty())
            return true;
        if(t.removeFirst()!=t.removeLast())
            return false;
        else
            return isPalindrome(t);
    }

    public boolean isPalindrome(String word) {
        Deque x = wordToDeque(word);
        return isPalindrome(x);
    }



}
