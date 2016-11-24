package com.pp.ohmyhead.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.pp.ohmyhead.controller.InputManagement;
import com.pp.ohmyhead.factory.GameRender;
import com.pp.ohmyhead.factory.GameWorld;


/**
 * Created by htsi.
 * Since: 11/18/16 on 11:37 AM
 * Project: ohmyhead
 */
public class GamePlay implements Screen {

    private GameWorld gameWorld;
    private GameRender gameRender;

    public GamePlay() {
        //float screenWidth = Gdx.graphics.getWidth();
        //float screenHeight = Gdx.graphics.getHeight();

        float gameWidth = 384;
        float gameHeight = 512;

        //int midPointY = (int)gameHeight/2;
        gameWorld = new GameWorld();
        gameRender = new GameRender(gameWorld, (int)gameWidth, (int) gameHeight);

        Gdx.input.setInputProcessor(new InputManagement());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        gameWorld.update(delta);
        gameRender.render(delta);
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
