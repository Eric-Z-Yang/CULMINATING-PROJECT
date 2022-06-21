package com.ics.culminatinggame;

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



public class Player extends InputAdapter implements Screen {

    private Stage stage;
    private Texture playerImageNormal;

    private Texture blockImage;

    private Texture background;

    private Texture keyImage;

    private SpriteBatch batch;

    private int playerMovementY = 270;

    private int playerMovementX = 0;

    private OrthographicCamera playerView;

    private Rectangle playerRectangle;

    private Rectangle blockRectangle;

    private Rectangle keyRectangle;

    private int previousX;

    private int previousY;

    private Array<Rectangle> keys;

    private boolean hasItem = false;

    @Override
    public void show() {

        playerImageNormal = new Texture("Player normal 32ver.png");
        background = new Texture("ICS CULMINATING TILEMAP LEVEL 1 (PNG BIG).png");
        blockImage = new Texture ("BLock 64ver.png");
        keyImage = new Texture( ("Key 40x20ver Transparent.png"));
        playerRectangle = new Rectangle(playerMovementX, playerMovementY, playerImageNormal.getWidth(), playerImageNormal.getHeight());
        blockRectangle = new Rectangle(500, 500, blockImage.getWidth(), blockImage.getHeight()); // <<CHANGE X and Y later for the block placing array);


        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        playerView = new OrthographicCamera();
        playerView.setToOrtho(false, 1024, 1024);


        keys = new Array<Rectangle>();
        spawnItem();
    }

    private void spawnItem () {
        keyRectangle = new Rectangle(70, 137, keyImage.getWidth(), keyImage.getHeight());
        keys.add(keyRectangle);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        ScreenUtils.clear(0, 0, 0.2f, 1);

        playerView.update();

        batch.setProjectionMatrix(playerView.combined); // TAKE OUT LATER IF NOTHING HAPPENS

        batch.begin();
        stage.draw();
        batch.draw (background, 0, 0);
        batch.draw (playerImageNormal, playerMovementX, playerMovementY);
        batch.draw (blockImage, 500, 500);
        for (Rectangle keyRectangle: keys) {
            batch.draw(keyImage, 70, 137);
        }

       // door.doorImageOpen.draw(batch);

        batch.end(); //REMOVE LATER FOR TEST

        if (blockRectangle.overlaps(playerRectangle)) {

            System.out.println ("Debugging: COLLISION DETECTED");
            playerMovementX = previousX;
            playerMovementY = previousY;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {

            previousY = playerMovementY;
            playerMovementY += 500 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

            previousY = playerMovementY;
            playerMovementY -= 500 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            previousX = playerMovementX;
            playerMovementX -= 500 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            previousX = playerMovementX;
            playerMovementX += 500 * Gdx.graphics.getDeltaTime();
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

        Iterator<Rectangle> iter = keys.iterator();
        while(iter.hasNext()) {
//
            Rectangle keyRectangle = iter.next();
            if (playerRectangle.overlaps(keyRectangle)) {
                System.out.println ("Debugging: Item has been gotten\n-----------------\n-------------------\n---------------\n------------------");
                hasItem = true;
                iter.remove();
            }
//
        }

        playerRectangle = new Rectangle(playerMovementX, playerMovementY, playerImageNormal.getWidth(), playerImageNormal.getHeight());
        blockRectangle = new Rectangle(500, 500, blockImage.getWidth(), blockImage.getHeight()); // <<CHANGE X and Y later for the block placing array);


        //batch.end();
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











//package com.ics.culminatinggame;
//
//import java.util.Iterator;
//
//import com.badlogic.gdx.InputAdapter;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.utils.ScreenUtils;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.utils.Array;
//
//
//
//public class Player extends GameObject{
//
//    private int playerMovementX;
//
//    private int playerMovementY;
//
//    private int previousX;
//
//    private int previousY;
//
//    public Player(Texture objectTexture, Rectangle objectHitBox, int playerMovementX, int playerMovementY, int previousX, int previousY) {
//
//        super(objectTexture, objectHitBox);
//
//        this.playerMovementY = playerMovementY;
//        this.playerMovementX = playerMovementX;
//        this.previousX = previousX;
//        this.previousY = previousY;
//    }
//
//    public void movementOfPlayer () {
//
//        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
//
//            previousY = playerMovementY;
//            playerMovementY += 500 * Gdx.graphics.getDeltaTime();
//        }
//
//        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
//
//            previousY = playerMovementY;
//            playerMovementY -= 500 * Gdx.graphics.getDeltaTime();
//        }
//
//        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//
//            previousX = playerMovementX;
//            playerMovementX -= 500 * Gdx.graphics.getDeltaTime();
//        }
//
//        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//
//            previousX = playerMovementX;
//            playerMovementX += 500 * Gdx.graphics.getDeltaTime();
//        }
//
//        if (playerMovementX < 0) {
//
//            playerMovementX = 0;
//        }
//
//        if (playerMovementX > 1024 - 32) {
//
//            playerMovementX = 1024 - 32;
//        }
//
//        if (playerMovementY < 0) {
//
//            playerMovementY = 0;
//        }
//
//        if (playerMovementY > 1024 - 32) {
//
//            playerMovementY = 1024 - 32;
//        }
//
//        System.out.println ("DEBUG:\n-------------\nCoordinates\nX: " + playerMovementX + "\nY: " + playerMovementY);
//
//    }
//
//    public void playerBlockCollision (Rectangle player, Rectangle block) {
//        if (block.overlaps(player)) {
//
//            System.out.println ("Debugging: COLLISION DETECTED");
//            playerMovementX = previousX;
//            playerMovementY = previousY;
//        }
//    }
//}

//if (blockRectangle.overlaps(playerRectangle)) {
//
//        System.out.println ("Debugging: COLLISION DETECTED");
//        playerMovementX = previousX;
//        playerMovementY = previousY;
//        }
//
//        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
//
//        previousY = playerMovementY;
//        playerMovementY += 500 * Gdx.graphics.getDeltaTime();
//        }
//
//        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
//
//        previousY = playerMovementY;
//        playerMovementY -= 500 * Gdx.graphics.getDeltaTime();
//        }
//
//        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//
//        previousX = playerMovementX;
//        playerMovementX -= 500 * Gdx.graphics.getDeltaTime();
//        }
//
//        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//
//        previousX = playerMovementX;
//        playerMovementX += 500 * Gdx.graphics.getDeltaTime();
//        }
//
//        if (playerMovementX < 0) {
//
//        playerMovementX = 0;
//        }
//
//        if (playerMovementX > 1024 - 32) {
//
//        playerMovementX = 1024 - 32;
//        }
//
//        if (playerMovementY < 0) {
//
//        playerMovementY = 0;
//        }
//
//        if (playerMovementY > 1024 - 32) {
//
//        playerMovementY = 1024 - 32;
//        }
//
//        System.out.println ("DEBUG:\n-------------\nCoordinates\nX: " + playerMovementX + "\nY: " + playerMovementY);
//
//        // <<EXTRA COLLISION DETECTION FOR TEST>>
//        if (blockRectangle.overlaps(playerRectangle)) {
//
//        System.out.println ("Debugging: COLLISION DETECTED");
//        playerMovementX = previousX;
//        playerMovementY = previousY;
//        }
//
//        Iterator<Rectangle> iter = keys.iterator();
//        while(iter.hasNext()) {
//        Rectangle keyRectangle = iter.next();
//        if (playerRectangle.overlaps(keyRectangle)) {
//        System.out.println ("Debugging: Item has been gotten\n-----------------\n-------------------\n---------------\n------------------");
//        hasItem = true;
//        iter.remove();
//        }
//        }