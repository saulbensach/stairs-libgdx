package com.bensach.saul.game.stairs;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class StairSmall extends Stair {

    public StairSmall(World world, Vector2 position) {
        super.createBody(world, position, new Vector2(10,10));
        position.add(20,20);
    }

}
