package com.bensach.saul.entities.stairs;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class StairExtraLarge extends Stair {

    public StairExtraLarge(World world, Vector2 position) {
        super.createEntity(world, position, new Vector2(60,10));
        position.add(120,20);
    }

}
