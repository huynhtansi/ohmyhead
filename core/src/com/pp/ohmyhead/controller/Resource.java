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

    public static Texture bg1a, bg2a, bg3a;
    public static TextureRegion bg1aRegion , bg2aRegion, bg3aRegion;

    public static Texture bg1b, bg2b, bg3b;
    public static TextureRegion bg1bRegion, bg2bRegion, bg3bRegion;

    public static Texture ob1a, ob1b, ob2a, ob2b, ob3a, ob3b;
    public static TextureRegion ob1aRegion, ob1bRegion, ob2aRegion, ob2bRegion, ob3aRegion, ob3bRegion;

    public static Texture bgAtmosphere;
    public static TextureRegion bgAtmosphereRegion;

    public static Texture startLine;
    public static TextureRegion startLineRegion;

    public static void load() {

        bg1a = new Texture(Gdx.files.internal("map/map1a@2x.png"));
        bg1a.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bg1aRegion = new TextureRegion(bg1a, 0,0, 1536, 2048);

        bg1b = new Texture(Gdx.files.internal("map/map1b@2x.png"));
        bg1b.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bg1bRegion = new TextureRegion(bg1b, 0,0, 1536, 2048);

        bg2a = new Texture(Gdx.files.internal("map/map2a@2x.png"));
        bg2a.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bg2aRegion = new TextureRegion(bg2a, 0,0, 1536, 2048);

        bg2b = new Texture(Gdx.files.internal("map/map2b@2x.png"));
        bg2b.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bg2bRegion = new TextureRegion(bg2b, 0,0, 1536, 2048);

        bg3a = new Texture(Gdx.files.internal("map/map3a@2x.png"));
        bg3a.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bg3aRegion = new TextureRegion(bg3a, 0,0, 1536, 2048);

        bg3b = new Texture(Gdx.files.internal("map/map3b@2x.png"));
        bg3b.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bg3bRegion = new TextureRegion(bg3b, 0,0, 1536, 2048);

        bgAtmosphere = new Texture(Gdx.files.internal("map/mapbg@2x.png"));
        bgAtmosphere.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bgAtmosphereRegion = new TextureRegion(bgAtmosphere, 0,0, 200, 2048);

        startLine = new Texture(Gdx.files.internal("map/startline@2x.png"));
        startLine.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        startLineRegion = new TextureRegion(startLine, 0, 0, 1536, 154);

        font = new BitmapFont(Gdx.files.internal("font/text.fnt"));
        shadow = new BitmapFont(Gdx.files.internal("font/shadow.fnt"));
        //shadow.setScale(.25f, -.25f);

        ob1a = new Texture(Gdx.files.internal("obstacle/map1_block1@2x.png"));
        ob1a.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        ob1aRegion = new TextureRegion(ob1a, 0,0, 600, 216);

        ob1b = new Texture(Gdx.files.internal("obstacle/map1_block2@2x.png"));
        ob1b.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        ob1bRegion = new TextureRegion(ob1b, 0,0, 600, 216);

        ob2a = new Texture(Gdx.files.internal("obstacle/map2_block1@2x.png"));
        ob2a.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        ob2aRegion = new TextureRegion(ob2a, 0,0, 605, 236);

        ob2b = new Texture(Gdx.files.internal("obstacle/map2_block2@2x.png"));
        ob2b.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        ob2bRegion = new TextureRegion(ob2b, 0,0, 600, 223);

        ob3a = new Texture(Gdx.files.internal("obstacle/map3_block1@2x.png"));
        ob3a.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        ob3aRegion = new TextureRegion(ob3a, 0,0, 600, 200);

        ob3b = new Texture(Gdx.files.internal("obstacle/map3_block2@2x.png"));
        ob3b.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        ob3bRegion = new TextureRegion(ob3b, 0,0, 600, 200);
    }

    public static void dispose() {
        bg1a.dispose();
        bg1b.dispose();
        bg2a.dispose();
        bg2b.dispose();
        startLine.dispose();
    }
}
