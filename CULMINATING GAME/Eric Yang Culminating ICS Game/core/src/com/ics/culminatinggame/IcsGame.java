package com.ics.culminatinggame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Screen;



public class IcsGame extends Game {
	SpriteBatch batch;
	Texture img;
	public Screen playerCharacter;

	@Override
	public void create() {

		playerCharacter = new Player();
		setScreen(playerCharacter);

	}



}
