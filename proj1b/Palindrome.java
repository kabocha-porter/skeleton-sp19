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
        if (t.isEmpty()||t.size() == 1)
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


    /**
     * return true if the word is a off-by-one palindrome, without recursion
     * @source kevin chang
     */
    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> x = wordToDeque(word);
        if (x.isEmpty()||x.size() == 1)
            return true;
        while(cc.equalChars(x.removeFirst(), x.removeLast()))
        {
            if (x.size() <= 1)
                return true;
        }
        return false;
    }



}
