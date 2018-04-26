package com.bensach.saul.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Player {

    private Body body;
    private int width, height;
    private Vector2 position;
    private Vector2 velocity;
    private int MAX_VELOCITY = 4000;

    public Player(Vector2 position, World world){
        this.position = position;
        position.add(20,40);
        width = 5;
        height = 10;
        initPlayer(world);
    }

    public void update(){
        position = body.getPosition();
        velocity = body.getLinearVelocity();
        if(Math.abs(velocity.x) > MAX_VELOCITY){
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            body.setLinearVelocity(velocity);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A) && velocity.x > -MAX_VELOCITY){
            body.applyLinearImpulse(-2, 0, position.x, position.y,true);
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            body.applyLinearImpulse(2,200, position.x, position.y, true);

        }else{
            body.applyLinearImpulse(2, 0, position.x, position.y, true);
        }

    }

    public Vector2 getPosition() {
        return position;
    }

    private void initPlayer(World world){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position.x + width, position.y + height);
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width,height);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.0f;
        fixtureDef.friction = 0.0f;
        fixtureDef.restitution = 0.0f;
        body.createFixture(fixtureDef);
        shape.dispose();
    }

}
