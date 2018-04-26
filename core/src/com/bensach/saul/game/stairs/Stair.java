package com.bensach.saul.game.stairs;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public abstract class Stair {

    protected Body body;

    public void createBody(World world, Vector2 position, Vector2 size){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(position.x + size.x,position.y + size.y + (size.y/2));
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size.x, size.y);
        body.createFixture(shape,0.0f);
        shape.dispose();
    }

}
