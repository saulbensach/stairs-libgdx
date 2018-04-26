package com.bensach.saul.game.stairs;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class StairLarge extends Stair {

    public StairLarge(World world, Vector2 position) {
        super.createBody(world, position, new Vector2(40,10));
        position.add(80,20);
    }

}
