import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome("fine"));
        assertFalse(palindrome.isPalindrome("ababa"));
    }

    static CharacterComparator cc = new OffByN(5);
    @Test
    public void testOffByOne(){
        assertTrue(palindrome.isPalindrome("sworn", cc));
        assertFalse(palindrome.isPalindrome("fake",cc));
        assertTrue(palindrome.isPalindrome("a",cc));
        assertFalse(palindrome.isPalindrome("flake",cc));
        assertFalse(palindrome.isPalindrome("pedal",cc));

    }
}