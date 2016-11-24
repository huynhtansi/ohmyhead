package com.pp.ohmyhead.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pp.ohmyhead.controller.Resource;
import com.pp.ohmyhead.model.Background;
import com.pp.ohmyhead.model.ScreenScrolling;


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
    private TextureRegion bgA, bgB, startLineRegion;

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
    }

    public void render(float runTime) {

        //Gdx.gl.glClearColor(1, 1, 1, 1.0f);
        //
        //Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);


        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(81/255.0f, 191/255.0f, 205/255.0f, 1.0f);
        shapeRenderer.rect(0, 0, 100, 100);
        shapeRenderer.end();

        spriteBatch.begin();
        spriteBatch.disableBlending();

        renderBG();

        spriteBatch.enableBlending();

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
            //spriteBatch.draw(startLineRegion, bB.getX(), bB.getY(), 0, 0, startLine.getWidth(), startLine.getHeight(), 0.25f, 0.25f, 0);
        }



        spriteBatch.draw(bgA, bA.getX(), bA.getY(), 0, 0, bA.getWidth(), bA.getHeight(), 0.25f, 0.25f, 0);
        spriteBatch.draw(bgB, bB.getX(), bB.getY(), 0, 0, bB.getWidth(), bB.getHeight(), 0.25f, 0.25f, 0);

        spriteBatch.draw(startLineRegion, startLine.getX(), startLine.getY(), 0, 0, startLine.getWidth(), startLine.getHeight(), 0.25f, 0.25f, 0);

    }
}
