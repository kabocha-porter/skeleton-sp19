package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

public class TestClorus {

    @Test
    public void testBasics() {
        Clorus p = new Clorus(5);

        assertEquals(new Color(34, 0, 231), p.color());

        assertEquals(5, p.energy(), 0.01);

        p.move();
        assertEquals(4.97, p.energy(), 0.01);

        p.stay();
        assertEquals(4.96, p.energy(), 0.01);

        p.move();
        assertEquals(4.93, p.energy(), 0.01);

        p.stay();
        assertEquals(4.92, p.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Clorus p = new Clorus (2);
        Clorus q = p.replicate();
        assertEquals(1, p.energy(), 0.01);
        assertEquals(1, q.energy(), 0.01);
        Clorus r = q.replicate();
        assertEquals(0.5, q.energy(), 0.01);
        assertEquals(0.5, r.energy(), 0.01);
    }

    @Test
    public void testChoose() {

        // No empty adjacent spaces; stay.
        Clorus p = new Clorus(7.0);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Plip());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = p.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        // If any Plips are seen, attack.
        p = new Clorus(5.0);
        Plip q = new Plip();
        HashMap<Direction, Occupant> botPlip = new HashMap<Direction, Occupant>();
        botPlip.put(Direction.TOP, new Empty());
        botPlip.put(Direction.BOTTOM, q); //Plip of energy 1
        botPlip.put(Direction.LEFT, new Impassible());
        botPlip.put(Direction.RIGHT, new Impassible());

        actual = p.chooseAction(botPlip);
        expected = new Action(Action.ActionType.ATTACK, Direction.BOTTOM);

        assertEquals(expected, actual);

        p.attack(q);
        assertEquals(6, p.energy(), 0.01);


        // Energy >= 1 and Empty space available; replicate towards an empty space.
        p = new Clorus(1.2);
        HashMap<Direction, Occupant> topEmpty = new HashMap<Direction, Occupant>();
        topEmpty.put(Direction.TOP, new Empty());
        topEmpty.put(Direction.BOTTOM, new Impassible());
        topEmpty.put(Direction.LEFT, new Impassible());
        topEmpty.put(Direction.RIGHT, new Impassible());

        actual = p.chooseAction(topEmpty);
        expected = new Action(Action.ActionType.REPLICATE, Direction.TOP);

        assertEquals(expected, actual);



        // Energy < 1; Move to empty space.
        p = new Clorus(.99);

        actual = p.chooseAction(topEmpty);
        expected = new Action(Action.ActionType.MOVE, Direction.TOP);

        assertEquals(expected, actual);


    }

}
