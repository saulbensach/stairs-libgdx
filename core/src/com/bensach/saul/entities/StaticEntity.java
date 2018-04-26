package com.bensach.saul.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class StaticEntity extends Entity {

    public void createEntity(World world, Vector2 position, Vector2 size, FixtureDef fixtureDef) {
        BodyDef.BodyType bodyType = BodyDef.BodyType.StaticBody;
        super.createEntity(world, position, size, bodyType, fixtureDef);
    }
}
