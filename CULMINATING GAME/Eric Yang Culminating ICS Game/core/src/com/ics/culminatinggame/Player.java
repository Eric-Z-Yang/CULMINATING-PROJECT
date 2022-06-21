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



public class Player extends GameObject{

    private int playerMovementX;

    private int playerMovementY;

    private int previousX;

    private int previousY;

    public Player(Texture objectTexture, Rectangle objectHitBox, int playerMovementX, int playerMovementY, int previousX, int previousY) {

        super(objectTexture, objectHitBox);

        this.playerMovementY = playerMovementY;
        this.playerMovementX = playerMovementX;
        this.previousX = previousX;
        this.previousY = previousY;
    }

    public void movementOfPlayer () {

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

    }

    public void playerBlockCollision (Rectangle player, Rectangle block) {
        if (block.overlaps(player)) {

            System.out.println ("Debugging: COLLISION DETECTED");
            playerMovementX = previousX;
            playerMovementY = previousY;
        }
    }
}

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