package com.ics.culminatinggame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Screen;


public class IcsGame extends Game {

	SpriteBatch batch;
	Texture img;
	public Screen player;

	@Override
	public void create () {

		player = new Player();
		setScreen(player);
	}
}
