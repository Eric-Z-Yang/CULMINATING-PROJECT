package com.ics.culminatinggame;

//import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
//import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
//import com.badlogic.gdx.utils.TimeUtils;

public class Player extends ApplicationAdapter {

    private Texture playerImageNormal;
    private Texture playerImageDamage;
    private SpriteBatch batch;
    private OrthographicCamera playerGameView;
    private Rectangle playerShape;

   // @Override
    public void createPlayer() {

        playerImageNormal = new Texture(Gdx.files.internal("Player normal 64ver.png"));
        playerImageDamage = new Texture(Gdx.files.internal("Player damage 64ver.png"));


        playerGameView = new OrthographicCamera();
        playerGameView.setToOrtho(false, 800, 800);
        batch = new SpriteBatch();

        playerShape = new Rectangle();
        playerShape.x = ((800 / 2) - (64 / 2));
        playerShape.y = 20; // <<FOR NOW>>
        playerShape.width = 64;
        playerShape.height = 64;

    }

  //  @Override
    public void renderPlayerMovement() {

        ScreenUtils.clear(0, 0, 0.2f, 1);

        playerGameView.update();

        batch.setProjectionMatrix(playerGameView.combined);

        batch.begin();
        batch.draw(playerImageNormal, playerShape.x, playerShape.y);
        batch.end();

        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            playerGameView.unproject(touchPos);
            playerShape.x = touchPos.x - 64 / 2;
        }

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {

            playerShape.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {

            playerShape.x += 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {

            playerShape.y -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {

            playerShape.y += 200 * Gdx.graphics.getDeltaTime();
        }

        if (playerShape.x < 0) {

            playerShape.x = 0;
        }

        if (playerShape.x > 800 - 64) {

            playerShape.x = 800 - 64;
        }

        if (playerShape.y < 0) {

            playerShape.y = 0;
        }

        if (playerShape.y > 800 - 64) {

            playerShape.y = 800 - 64;
        }
    }

    //@Override
    public void objectDeletion() {

        playerImageDamage.dispose();
        playerImageNormal.dispose();
        batch.dispose();
    }

}
