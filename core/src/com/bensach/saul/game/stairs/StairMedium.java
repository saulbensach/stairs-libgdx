package com.bensach.saul.game.stairs;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class StairMedium extends Stair {

    public StairMedium(World world, Vector2 position) {
        super.createBody(world, position, new Vector2(20,10));
        position.add(40,20);
    }

}
