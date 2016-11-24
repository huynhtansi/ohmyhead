package com.pp.ohmyhead.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by htsi.
 * Since: 11/18/16 on 12:15 PM
 * Project: ohmyhead
 */
public class Resource {

    public static BitmapFont font, shadow;

    public static Texture bg1a, bg2a;
    public static TextureRegion bg1aRegion , bg2aRegion;

    public static Texture bg1b, bg2b;
    public static TextureRegion bg1bRegion, bg2bRegion;

    public static Texture startLine;
    public static TextureRegion startLineRegion;

    public static void load() {

        bg1a = new Texture(Gdx.files.internal("map1a@2x.png"));
        bg1a.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bg1aRegion = new TextureRegion(bg1a, 0,0, 1536, 2048);


        bg1b = new Texture(Gdx.files.internal("map1b@2x.png"));
        bg1b.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bg1bRegion = new TextureRegion(bg1b, 0,0, 1536, 2048);

        bg2a = new Texture(Gdx.files.internal("map2a@2x.png"));
        bg2a.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bg2aRegion = new TextureRegion(bg2a, 0,0, 1536, 2048);


        bg2b = new Texture(Gdx.files.internal("map2b@2x.png"));
        bg2b.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bg2bRegion = new TextureRegion(bg2b, 0,0, 1536, 2048);

        startLine = new Texture(Gdx.files.internal("startline@2x.png"));
        startLine.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        startLineRegion = new TextureRegion(startLine, 0, 0, 1536, 154);

        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        shadow = new BitmapFont(Gdx.files.internal("shadow.fnt"));
        //shadow.setScale(.25f, -.25f);
    }

    public static void dispose() {
        bg1a.dispose();
        bg1b.dispose();
        bg2a.dispose();
        bg2b.dispose();
        startLine.dispose();
    }
}
