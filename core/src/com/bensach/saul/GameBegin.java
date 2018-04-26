package com.bensach.saul;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

public class GameBegin extends Game {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Box2DDebugRenderer debugRenderer;
    private GameScreen gameScreen;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(350,300);
        debugRenderer = new Box2DDebugRenderer();
        gameScreen = new GameScreen(this,batch,camera,debugRenderer);

        setScreen(gameScreen);
    }
}
