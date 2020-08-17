package creatures;

import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.random;
import static huglife.HugLifeUtils.randomEntry;

public class Clorus extends Creature {

    /**
     * color red
     */
    double r;

    /**
     * color blue
     */
    double b;

    /**
     * color green
     */
    double g;

    /**
     * constructor with energy e
     */
    public Clorus(double e){
        super("clorus");
        r = 0;
        b = 0;
        g = 0;

        energy = e;

    }

    /**
     * default constructor
     */
    public Clorus(){
        this(1);

    }

    /**
     * color scheme of clorus
     */
    public Color color(){
        return color(34,0,231);
    }

    /**
     * decreases energy after move
     */
    public void move(){
        energy = energy - 0.03;
    }

    /**
     * lose energy after move
     */
    public void stay(){
        energy = energy - 0.01;
    }


    /**
     * gain opponent's energy after attack
     */
    public void attack(Creature c){
        energy = c.energy() + energy;
    }

    /**
     * when replicate, keeps 50% energy and distribute the rest to the copy
     */

    public Clorus replicate(){
        energy = energy/2;
        Clorus h = new Clorus(energy);
        return h;
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors){

       //store empty neighbors and plip neighbors for later use
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> plipNeighbors = new ArrayDeque<>();

        for (Direction i : Direction.values())
        {
            if(neighbors.get(i).name().equals("empty"))
            {
                emptyNeighbors.add(i);
            }
            if(neighbors.get(i).name().equals("plip"))
            {
                plipNeighbors.add(i);
            }
        }
        //if no empty squares, stay
        if(emptyNeighbors.isEmpty())
        {
            return new Action(Action.ActionType.STAY);
        }


        //if neighbors have plip, attack
        else if(!plipNeighbors.isEmpty())
        {
            return new Action(Action.ActionType.ATTACK, randomEntry(plipNeighbors)); //how to pass this direction to attack()
        }

        //if energy >= 1, replicate to a random empty space
        else if(energy >= 1)
        {
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
        }

        //move to a random space
        else
        {
            return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
        }



    }

}



