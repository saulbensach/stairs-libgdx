package com.bensach.saul.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public abstract class Entity {

    protected Body body;

    public void createEntity(
            World world,
            Vector2 position,
            Vector2 size,
            BodyDef.BodyType bodyType,
            FixtureDef fixtureDef
    ){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = bodyType;
        bodyDef.position.set(bodyDef.position.set(position.x + size.x,position.y + size.y + (size.y/2)));
        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
        fixtureDef.shape.dispose();
    }
}
