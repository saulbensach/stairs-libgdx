package com.bensach.saul;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.bensach.saul.game.player.Player;
import com.bensach.saul.game.stairs.StairsManager;

public class GameScreen extends BaseScreen {

    private World world;
    private Vector2 gravity;
    private StairsManager stairsManager;
    private Vector2 startPoint;
    private Player player;
    private int numberStairs = 5;

    public GameScreen(GameBegin game, SpriteBatch batch, OrthographicCamera camera, Box2DDebugRenderer debugRenderer) {
        super(game, batch, camera, debugRenderer);
        gravity = new Vector2(0,-250);
        startPoint = new Vector2(-120,-120);
        world = new World(gravity, true);
        player = new Player(new Vector2(startPoint.x, startPoint.y), world);
        stairsManager = new StairsManager(startPoint);
        stairsManager.generateStairs(numberStairs, world);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if(player.getPosition().x > stairsManager.nextStairPosition.x){
            stairsManager.clean(world);
            stairsManager.nextStairPosition.add(0,-20);
            stairsManager.generateStairs(numberStairs,world);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            stairsManager.clean(world);
            stairsManager.generateStairs(numberStairs,world);
        }
        player.update();
        camera.position.set(player.getPosition(),0);
        camera.update();
        world.step(1/60f,6,2);
        debugRenderer.render(world, camera.combined);
    }
}
