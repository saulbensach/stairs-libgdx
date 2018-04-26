package com.bensach.saul.entities.stairs;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.bensach.saul.entities.StaticEntity;

public abstract class Stair extends StaticEntity{

    public void createEntity(World world, Vector2 position, Vector2 size){
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size.x, size.y);
        fixtureDef.shape = shape;
        fixtureDef.density = 0.0f;
        super.createEntity(world,position,size,fixtureDef);
    }

    public Body getBody(){
       return super.body;
    }

}
