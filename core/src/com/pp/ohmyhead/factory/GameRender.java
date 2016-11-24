package com.pp.ohmyhead.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pp.ohmyhead.controller.Resource;
import com.pp.ohmyhead.model.Background;
import com.pp.ohmyhead.model.Obstacle;
import com.pp.ohmyhead.model.ScreenScrolling;

import javax.microedition.khronos.opengles.GL10;
import java.util.Iterator;
import java.util.Random;


/**
 * Created by htsi.
 * Since: 11/18/16 on 11:39 AM
 * Project: ohmyhead
 */
public class GameRender {


    private GameWorld gameWorld;

    private OrthographicCamera camera;

    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;

    private int width;
    private int height;

    private Background bA, bB, startLine;
    private TextureRegion bgA, bgB, startLineRegion, bgAtmosphereRegion;

    private ScreenScrolling screenScrolling;


    public GameRender(GameWorld gameWorld, int width, int height) {

        Gdx.app.log("GameRender", "Width: " + width + " - Height: " +height);
        this.gameWorld = gameWorld;

        this.width = width;
        this.height = height;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(camera.combined);

        initGameObjects();
        initResource();
    }

    private void initGameObjects() {
        screenScrolling = gameWorld.getScreenScrolling();

        bA = screenScrolling.getbA();
        bB = screenScrolling.getbB();
        startLine = screenScrolling.getStartLine();
    }

    private void initResource() {
        bgA = Resource.bg1aRegion;
        bgB = Resource.bg1bRegion;
        startLineRegion = Resource.startLineRegion;
        bgAtmosphereRegion = Resource.bgAtmosphereRegion;
    }

    public void render(float runTime) {

        //Gdx.gl.glClearColor(1, 1, 1, 1.0f);
        //
        //Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);




        spriteBatch.begin();
        spriteBatch.enableBlending();

        renderBG();

        spriteBatch.disableBlending();
//        Gdx.gl.glEnable(GL10.GL_BLEND);
//        Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
//        shapeRenderer.setProjectionMatrix(camera.combined);
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.setColor(new Color(0, 1, 0, 0.5f));
//        shapeRenderer.end();
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.setColor(255/255.0f, 255/255.0f, 255/255.0f, 0.3f);
//        shapeRenderer.rect(0, 0, 384, 512);
//        shapeRenderer.end();
//        Gdx.gl.glDisable(GL10.GL_BLEND);


        Resource.shadow.draw(spriteBatch, ""+screenScrolling.distance/10, 50, 100);
        Resource.font.draw(spriteBatch, ""+screenScrolling.distance/10, 50, 100);


        spriteBatch.end();

    }

    private void renderBG() {

        if (bA.getMapType() == 2) {
            bgA = Resource.bg2aRegion;
        }

        if (bB.getMapType() == 2) {
            bgB = Resource.bg2bRegion;
        }

        if (bA.getMapType() == 3) {
            bgA = Resource.bg3aRegion;
        }

        if (bB.getMapType() == 3) {
            bgB = Resource.bg3bRegion;
        }


        spriteBatch.draw(bgA, bA.getX(), bA.getY(), 0, 0, bA.getWidth(), bA.getHeight(), 0.25f, 0.25f, 0);
        spriteBatch.draw(bgB, bB.getX(), bB.getY(), 0, 0, bB.getWidth(), bB.getHeight(), 0.25f, 0.25f, 0);

        spriteBatch.draw(startLineRegion, startLine.getX(), startLine.getY(), 384.0f, 38.5f);

        Iterator<Obstacle> iterator = screenScrolling.obstacles.iterator();
        while (iterator.hasNext()) {
            Obstacle obstacle = iterator.next();
            if (obstacle.getY() > 512)
                iterator.remove();
            TextureRegion ob = Resource.ob1aRegion;

            switch (screenScrolling.overMap) {
                case 0:
                    if (obstacle.getType() == 1)
                        ob = Resource.ob1aRegion;
                    else
                        ob = Resource.ob1bRegion;
                    break;
                case 1:
                    if (obstacle.getType() == 1)
                        ob = Resource.ob2aRegion;
                    else
                        ob = Resource.ob2bRegion;
                    break;
                case 2:
                    if (obstacle.getType() == 1)
                        ob = Resource.ob3aRegion;
                    else
                        ob = Resource.ob3bRegion;
                    break;
            }
            spriteBatch.draw(ob, obstacle.getX(), 0,0,obstacle.getY(), obstacle.getWidth(), obstacle.getHeight(), 0.25f, 0.25f, 0);
        }
    }
}
