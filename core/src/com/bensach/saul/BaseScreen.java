package com.bensach.saul;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

public abstract class BaseScreen implements Screen {

    protected GameBegin game;
    protected SpriteBatch batch;
    protected OrthographicCamera camera;
    protected Box2DDebugRenderer debugRenderer;
    private BitmapFont font;

    public BaseScreen(
            GameBegin game,
            SpriteBatch batch,
            OrthographicCamera camera,
            Box2DDebugRenderer debugRenderer
    ){
        this.game = game;
        this.batch = batch;
        this.camera = camera;
        this.debugRenderer = debugRenderer;
        font = new BitmapFont();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch,Gdx.graphics.getFramesPerSecond()+" FPS",20,20);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
