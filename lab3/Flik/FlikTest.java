import org.junit.Test;
import static org.junit.Assert.*;

/**
 * the problem with the Horrible Steve is the isSameNumber return (128,128) as false instead
 * of true
 */
public class FlikTest {

    @Test
    public void testFlik(){
        assertTrue(Flik.isSameNumber(0,0));
        assertFalse(Flik.isSameNumber(128,128));
    }
}
