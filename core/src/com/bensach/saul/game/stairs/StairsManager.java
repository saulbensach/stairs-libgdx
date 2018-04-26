package com.bensach.saul.game.stairs;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.Random;

public class StairsManager {

    private Random random;
    private ArrayList<Stair> stairs;
    public Vector2 nextStairPosition;
    public int timesGenerated;

    public StairsManager(Vector2 startPoint){
        stairs = new ArrayList<Stair>();
        random = new Random();
        nextStairPosition = startPoint;
        timesGenerated = 0;
    }

    public void clean(World world){
        for (Stair stair : stairs){
            world.destroyBody(stair.body);
        }
        stairs.clear();
    }

    public void generateStairs(int number, World world){
        System.out.println("Iteration number: "+ (++timesGenerated));
        int generated = 0;
        while (generated < number){
            switch (random.nextInt(4)){
                case 0: stairs.add(new StairSmall(world, nextStairPosition));break;
                case 1: stairs.add(new StairMedium(world, nextStairPosition));break;
                case 2: stairs.add(new StairLarge(world, nextStairPosition));break;
                case 3: stairs.add(new StairExtraLarge(world, nextStairPosition));break;
            }
            generated++;
        }
    }

}
