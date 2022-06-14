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
import com.badlogic.gdx.math.Rectangle;



public class Player extends InputAdapter implements Screen {

    private Stage stage;
    private Texture playerImageNormal;

    private Texture blockImage;

    private Texture background;

    private SpriteBatch batch;

    private int playerMovementY = 270;

    private int playerMovementX = 0;

    private OrthographicCamera playerView;

    private Rectangle playerRectangle;

    private Rectangle blockRectangle;

    private int previousX;

    private int previousY;

    @Override
    public void show() {

        playerImageNormal = new Texture("Player normal 32ver.png");
        background = new Texture("ICS CULMINATING TILEMAP LEVEL 1 (PNG BIG).png");
        blockImage = new Texture ("BLock 64ver.png");
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        playerView = new OrthographicCamera();
        playerView.setToOrtho(false, 1024, 1024);
        playerRectangle = new Rectangle(playerMovementX, playerMovementY, playerImageNormal.getWidth(), playerImageNormal.getHeight());
        blockRectangle = new Rectangle(500, 500, blockImage.getWidth(), blockImage.getHeight()); // <<CHANGE X and Y later for the block placing array);

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
        batch.draw (blockImage, 500, 500);

        if (blockRectangle.overlaps(playerRectangle)) {

            System.out.println ("Debugging: COLLISION DETECTED");
            playerMovementX = previousX;
            playerMovementY = previousY;
        }


        if (Gdx.input.isKeyPressed(Input.Keys.W)) {

            previousY = playerMovementY;
            playerMovementY += 300 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {

            previousY = playerMovementY;
            playerMovementY -= 300 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {

            previousX = playerMovementX;
            playerMovementX -= 300 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {

            previousX = playerMovementX;
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

        // <<EXTRA COLLISION DETECTION FOR TEST>>
        if (blockRectangle.overlaps(playerRectangle)) {

            System.out.println ("Debugging: COLLISION DETECTED");
            playerMovementX = previousX;
            playerMovementY = previousY;
        }

        playerRectangle = new Rectangle(playerMovementX, playerMovementY, playerImageNormal.getWidth(), playerImageNormal.getHeight());
        blockRectangle = new Rectangle(500, 500, blockImage.getWidth(), blockImage.getHeight()); // <<CHANGE X and Y later for the block placing array);


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
        blockImage.dispose();
    }

}