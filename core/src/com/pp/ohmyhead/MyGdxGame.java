package com.pp.ohmyhead;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pp.ohmyhead.controller.Resource;
import com.pp.ohmyhead.factory.GameRender;
import com.pp.ohmyhead.screen.GamePlay;

public class MyGdxGame extends Game {

	
	@Override
	public void create () {
		Resource.load();
		setScreen(new GamePlay());
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose () {
		Resource.dispose();
	}
}
