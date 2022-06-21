package com.ics.culminatinggame;

import com.badlogic.gdx.Game;
<<<<<<< Updated upstream
import com.badlogic.gdx.ApplicationAdapter;
=======
import com.badlogic.gdx.InputAdapter;
>>>>>>> Stashed changes
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Screen;


<<<<<<< Updated upstream

public class IcsGame extends Game {
	SpriteBatch batch;
	Texture img;
	public Screen playerCharacter;

	@Override
	public void create() {

		playerCharacter = new Player();
		setScreen(playerCharacter);

	}



=======
import java.util.Iterator;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;




public class IcsGame extends InputAdapter implements Screen {

//	SpriteBatch batch;
//	Texture img;
//	public Screen player;
//
//	@Override
//	public void create () {
//
//		player = new Player();
//		setScreen(player);
//	}
	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		ScreenUtils.clear(0, 0, 0.2f, 1);

		playerView.update();

		batch.setProjectionMatrix(playerView.combined); // TAKE OUT LATER IF NOTHING HAPPENS

		batch.begin();

		batch.end(); //REMOVE LATER FOR TEST

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {


	}

>>>>>>> Stashed changes
}
