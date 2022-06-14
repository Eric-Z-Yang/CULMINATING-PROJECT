package com.ics.culminatinggame;


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



public class Player extends InputAdapter implements Screen {

    private Stage stage;
    private Texture playerImageNormal;

    private Texture background;

    private SpriteBatch batch;

    private float playerMovementY = 270;

    private float playerMovementX = 0;

    private OrthographicCamera playerView;

    @Override
    public void show() {

        playerImageNormal = new Texture("Player normal 32ver.png");
        background = new Texture("ICS CULMINATING TILEMAP LEVEL 1 (PNG BIG).png");
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        playerView = new OrthographicCamera();
        playerView.setToOrtho(false, 1024, 1024);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        ScreenUtils.clear(0, 0, 0.2f, 1);

        playerView.update();

        batch.begin();
        stage.draw();
        batch.draw (background, 0, 0);
        batch.draw (playerImageNormal, playerMovementX, playerMovementY);

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {

            playerMovementY += 300 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {

            playerMovementY -= 300 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {

            playerMovementX -= 300 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {

            playerMovementX += 300 * Gdx.graphics.getDeltaTime();
        }

        if (playerMovementX < 0) {

            playerMovementX = 0;
        }

        if (playerMovementX > 1024 - 32) {

            playerMovementX = 1024 - 32;
        }

        if (playerMovementY < 0) {

            playerMovementY = 0;
        }

        if (playerMovementY > 1024 - 32) {

            playerMovementY = 1024 - 32;
        }

        System.out.println ("DEBUG:\n-------------\nCoordinates\nX: " + playerMovementX + "\nY: " + playerMovementY);

        batch.end();
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

        playerImageNormal.dispose();
        background.dispose();
    }

}